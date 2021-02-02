package com.code.custom.framework.db.pool1;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author danny
 * @date 2021/1/29下午10:44
 */
@Slf4j
@Data
@Accessors(chain = true)
public class ConnectionPool implements IConnectionPool {

    private ConnectionPoolProperty connectionPoolProperty;

    //连接池可用状态
    private Boolean isActive = Boolean.TRUE;

    // 空闲数据库连接队列
    private LinkedList<Connection> freeConnections = new LinkedList<>();

    // 活动数据库连接队列
    private LinkedList<Connection> activeConnections = new LinkedList<>();

    private ThreadLocal<Connection> currentConnectionThreadLocal = new ThreadLocal<>();

    public ConnectionPool() {
    }

    public ConnectionPool(ConnectionPoolProperty connectionPoolProperty) throws SQLException {
        this.connectionPoolProperty = connectionPoolProperty;
        // todo 校验dbPoolProperty合法性
        // 生成initConnection个初始化连接，并放入空闲数据库连接队列中
        for (int i = 0; i < connectionPoolProperty.getInitConnections(); i++) {
            try {
                Connection connection = DriverManager.getConnection(connectionPoolProperty.getUrl(), connectionPoolProperty.getUserName(), connectionPoolProperty.getPassword());
                freeConnections.add(connection);
            } catch (SQLException e) {
                log.error("ConnectionPool init error", e);
                throw e;
            }
        }
        log.info("ConnectionPool {} init success. initConnections:{}", connectionPoolProperty.getNodeName(),connectionPoolProperty.getInitConnections());
    }

    /**
     * 获取一个数据库连接，如果等待超时，返回null
     *
     * @return
     */
    @Override
    public Connection getConnection() throws Exception {
        Connection connection = getConnection(connectionPoolProperty.getTimeout(), connectionPoolProperty.getConninterval());
        return connection;
    }

    private synchronized Connection getConnection(long timeout, long conninterval) throws Exception {
        Connection connection = null;
        long startTime = System.currentTimeMillis();

        // 连接池中有空闲连接
        if (!freeConnections.isEmpty()) {
            connection = freeConnections.poll();
            //log.info("getConnection-get connection from freeConnections");
        }

        // 连接池中无空闲连接且当前活动连接数小于最大连接数
        if (freeConnections.isEmpty() && activeConnections.size() < connectionPoolProperty.getMaxConnections()) {
            //创建新的连接
            connection = DriverManager.getConnection(connectionPoolProperty.getUrl(), connectionPoolProperty.getUserName(), connectionPoolProperty.getPassword());
            //log.info("getConnection-create new connection");
        }

        // 连接池中无空闲连接且当前活动连接数等于最大连接数
        if (freeConnections.isEmpty() && activeConnections.size() == connectionPoolProperty.getMaxConnections()) {
            //log.info("getConnection-no connection");
        }

        if (isValidConnection(connection)) {
            currentConnectionThreadLocal.set(connection);
            activeConnections.offer(connection);
        } else {
            if (timeout > 0 && conninterval > 0) {
                // 如果超时时间小于重连间隔，只休眠超时时间后重新获取连接
                //log.info("getConnection-start wait");
                this.wait(Math.min(timeout, conninterval));
                long consumeTime = System.currentTimeMillis() - startTime;
                if (consumeTime < timeout) {
                    //log.info("getConnection-retry");
                    connection = getConnection(timeout - consumeTime, conninterval);
                }else{
                    throw new Exception("can not get more connection");
                }
            }else{
                throw new Exception("can not get more connection");
            }
        }

        return connection;
    }

    private boolean isValidConnection(Connection connection) {
        boolean isValid = false;
        try {
            if (connection != null && !connection.isClosed()) {
                isValid = true;
            }
        } catch (SQLException e) {
            log.error("isValidConnection error", e);
        }
        return isValid;
    }

    /**
     * 获得当前线程的连接库连接
     *
     * @return
     */
    @Override
    public Connection getCurrentConnection() {
        return currentConnectionThreadLocal.get();
    }

    /**
     * 释放当前数据库连接
     *
     * @param connection
     */
    @Override
    public synchronized void releaseConnection(Connection connection) throws SQLException {
        // 活动连接队列删除此连接
        activeConnections.remove(connection);
        // 删除当前线程连接
        currentConnectionThreadLocal.remove();
        // 添加到空闲连接
        if (isValidConnection(connection)) {

            freeConnections.offer(connection);
        } else {
            freeConnections.offer(newConnection());
        }
        // 唤醒getConnection中的wait
        this.notifyAll();
    }

    /**
     * 获取活跃的数据库连接数量
     *
     * @return
     */
    @Override
    public int getActiveNum() {
        return activeConnections.size();
    }

    /**
     * 获取空闲的数据库连接数量
     *
     * @return
     */
    @Override
    public int getFreeNum() {
        return freeConnections.size();
    }

    /**
     * 销毁当前连接池
     */
    @Override
    public synchronized void destroy() throws SQLException {
        while (freeConnections.size() > 0) {
            Connection connection = freeConnections.poll();
            connection.close();
        }
        while (activeConnections.size() > 0) {
            Connection connection = activeConnections.poll();
            connection.close();
        }
    }

    /**
     * 连接池是否可用
     *
     * @return
     */
    @Override
    public boolean isActive() {
        return isActive;
    }

    ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());


    /**
     * 检查连接池
     */
    @Override
    public void checkPool() {
        ScheduledExecutorService scheduledExecutorService
                = new ScheduledThreadPoolExecutor(
                2,
                new BasicThreadFactory
                        .Builder()
                        .namingPattern("check-db-pool-schedule-pool-%d")
                        .daemon(true)
                        .build()
        );

        // 当总连接数小于最小连接数时，补充新连接
        scheduledExecutorService.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int totalConnectionNum = freeConnections.size() + activeConnections.size();
                int addConnectionNum = connectionPoolProperty.getMinConnections() - totalConnectionNum;
                if (addConnectionNum > 0) {
                    log.info("schedule add new connections: {}", connectionPoolProperty.getMinConnections() - totalConnectionNum);
                    for (int i = 0; i < addConnectionNum; i++) {
                        try {
                            freeConnections.offer(newConnection());
                        } catch (SQLException e) {
                            log.error("schedule add new connections error", e);
                        }
                    }
                }
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);

        // 释放超过最大存活时间的空闲连接
        // TODO: 2021/2/1  
    }

    private Connection newConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(connectionPoolProperty.getUrl(), connectionPoolProperty.getUserName(), connectionPoolProperty.getPassword());
        return connection;
    }
}
