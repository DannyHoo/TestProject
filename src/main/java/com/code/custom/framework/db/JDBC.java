package com.code.custom.framework.db;

import java.sql.*;

/**
 * @author danny
 * @date 2021/1/29上午11:45
 */
public class JDBC {

    static {
        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        long start = System.currentTimeMillis();

        String url = "jdbc:mysql://152.32.141.88:3306/hishop_user?characterEncoding=utf-8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&serverTimezone=Africa/Lagos";
        String user = "root";
        String password = "mysqlP@ss1";
        String sql = "select * from t_user;";

        // 多次操作数据库，频繁获取、关闭连接，很耗时
        for (int i = 1; i <= 2; i++) {
            queryByStatement(url, user, password, sql);
            System.out.println(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("consumeTime : " + (end - start));
    }

    /**
     * 连接数据库简单例子
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void executeSqlExample() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://141.143.204.89:3306/hishop_user";
        String user = "root";
        String password = "123456";

        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 获取数据库连接
        Connection connection = DriverManager.getConnection(url, user, password);

        // 获取用于向数据库发送sql的statement
        Statement statement = connection.createStatement();

        // 执行sql语句
        ResultSet resultSet = statement.executeQuery("select * from t_user;");

        while (resultSet.next()) {
            System.out.println("id:" + resultSet.getObject("id") + " name:" + resultSet.getObject("userName"));
        }

        // 关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }


    public static <T> T queryByStatement(String url, String user, String password, String sql) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        statement.close();
        connection.close();
        return (T) resultSet;
    }

    public static <T> T queryByConnection(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        statement.close();
        return (T) resultSet;
    }


    /**
     * PreparedStatement相对于Statement来说可以防止sql注入
     * https://blog.csdn.net/czh500/article/details/88202971
     */
    public static void preparedStatementTest() {

    }

    public Connection getConnection(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
