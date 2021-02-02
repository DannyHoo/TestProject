package com.code.custom.framework.db;

import com.code.custom.framework.db.pool1.ConnectionPoolManager;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author danny
 * @date 2021/2/1下午6:12
 */
@Slf4j
public class Main {

    static ConnectionPoolManager connectionPoolManager;

    static {
        try {
            connectionPoolManager = ConnectionPoolManager.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://152.32.141.88:3306/jrkj-py?characterEncoding=utf-8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&serverTimezone=Africa/Lagos";
        String user = "root";
        String password = "mysqlP@ss1";
        String sql = "select * from t_user where mobileNo='1357924680';";

        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100; i++) {
            //queryByJDBC(url, user, password, sql);
            //queryByConnectionPool(sql);
            //System.out.println("finished:" + i);
            final int n = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Main.getInstance().queryByConnectionPool(n, sql);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            //queryByConnectionPool(1,sql);
        }
        long consumeTime = System.currentTimeMillis() - startTime;
        System.out.println("total consume time:" + consumeTime);
    }

    public static void queryByJDBC(String url, String user, String password, String sql) throws SQLException {
        JDBC.queryByStatement(url, user, password, sql);
        //total consume time:58372
    }

    public void queryByConnectionPool(int n, String sql) throws Exception {
        long startTime = System.currentTimeMillis();
        log.info("thread {} is start,startTime:{}", n, startTime);
        Connection connection = connectionPoolManager.getConnection("node2");
        JDBC.queryByConnection(connection, sql);
        connectionPoolManager.releaseConnection("node2", connection);
        long consumeTime = System.currentTimeMillis() - startTime;
        log.info("thread {} is finished,consumed time:{} startTime:{}", n, consumeTime, startTime); //441
    }

    private static Main main;

    public static Main getInstance() {
        if (main == null) {
            synchronized (Main.class) {
                if (main == null) {
                    main = new Main();
                }
            }
        }
        return main;
    }
}
