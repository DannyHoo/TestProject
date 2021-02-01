package com.code.custom.framework.db.pool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author danny
 * @date 2021/1/29下午10:33
 */
public interface IConnectionPool {

    /**
     * 获取一个数据库连接，如果等待超时，返回null
     *
     * @return
     */
    Connection getConnection() throws SQLException, InterruptedException;

    /**
     * 获得当前线程的连接库连接
     *
     * @return
     */
    Connection getCurrentConnection();

    /**
     * 释放当前数据库连接
     *
     * @param connection
     */
    void releaseConnection(Connection connection) throws SQLException;

    /**
     * 获取活跃的数据库连接数量
     *
     * @return
     */
    int getActiveNum();

    /**
     * 获取空闲的数据库连接数量
     *
     * @return
     */
    int getFreeNum();

    /**
     * 销毁当前连接池
     */
    void destroy() throws SQLException;

    /**
     * 连接池是否可用
     *
     * @return
     */
    boolean isActive();

    /**
     * 检查连接池
     */
    void checkPool();

}
