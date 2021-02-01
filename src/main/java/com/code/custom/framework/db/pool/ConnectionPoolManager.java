package com.code.custom.framework.db.pool;

import com.code.utils.PropertyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author danny
 * @date 2021/1/30下午12:09
 */
@Slf4j
public class ConnectionPoolManager {

    /**
     * 可以同时配置多个数据库节点
     * 每个数据库节点创建一个数据库连接池
     */
    private ConcurrentHashMap<String, IConnectionPool> connectionPools = new ConcurrentHashMap<>();

    private Set<String> drivers = new HashSet<>();

    private static ConnectionPoolManager connectionPoolManager;

    public ConnectionPoolManager() throws Exception {
        // 数据连接驱动
        String nodeName = PropertyUtil.getStringProperty("custom.datasource.pool.nodename");
        if (StringUtils.isEmpty(nodeName)) {
            throw new Exception("nodeName can not be empty");
        }
        String[] nodeNames = nodeName.split(",");

        for (String node : nodeNames) {
            String driver;
            ConnectionPoolProperty connectionPoolProperty = new ConnectionPoolProperty()
                    .setDriver(driver = PropertyUtil.getStringProperty(String.format("custom.datasource.pool.%s.driver", node)))
                    .setUrl(PropertyUtil.getStringProperty(String.format("custom.datasource.pool.%s.url", node)))
                    .setUserName(PropertyUtil.getStringProperty(String.format("custom.datasource.pool.%s.userName", node)))
                    .setPassword(PropertyUtil.getStringProperty(String.format("custom.datasource.pool.%s.password", node)))
                    .setInitConnections(PropertyUtil.getIntegerProperty(String.format("custom.datasource.pool.%s.initConnections", node)))
                    .setMinConnections(PropertyUtil.getIntegerProperty(String.format("custom.datasource.pool.%s.maxConnections", node)))
                    .setMaxConnections(PropertyUtil.getIntegerProperty(String.format("custom.datasource.pool.%s.minConnections", node)))
                    .setTimeout(PropertyUtil.getLongProperty(String.format("custom.datasource.pool.%s.timeout", node)))
                    .setConninterval(PropertyUtil.getLongProperty(String.format("custom.datasource.pool.%s.conninterval", node)));
            if (!drivers.contains(driver)) {
                Class.forName(driver);
                log.info("Driver {} loaded success.", driver);
            }
            IConnectionPool connectionPool = new ConnectionPool(connectionPoolProperty);
            connectionPools.put(node, connectionPool);
        }
    }

    public static synchronized ConnectionPoolManager getInstance() throws Exception {
        if (connectionPoolManager == null) {
            connectionPoolManager = new ConnectionPoolManager();
        }
        return connectionPoolManager;
    }


    /**
     * 从指定数据库连接池中获取连接
     *
     * @param poolName
     * @return
     */
    public Connection getConnection(String poolName) throws Exception {
        IConnectionPool connectionPool = connectionPools.get(poolName);
        if (connectionPool == null) {
            throw new Exception("connectionPool is null");
        }
        return connectionPool.getConnection();
    }


}
