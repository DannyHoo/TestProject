package com.code.custom.framework.db.pool1;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author danny
 * @date 2021/1/29下午10:19
 */
@Data
@Accessors(chain = true)
public class ConnectionPoolProperty {

    // 数据连接驱动
    private String nodeName;

    // 数据连接驱动
    private String driver;

    // 数据连接url
    private String url;

    // 数据连接用户名
    private String userName;

    // 数据连接密码
    private String password;

    // 连接池默认连接数
    private int initConnections;

    // 连接池最大连接数
    private int maxConnections;

    // 连接池最小连接数
    private int minConnections;

    // 获取连接超时时间 ，单位毫秒，0永不超时
    private long timeout;

    // 重连间隔时间 ，单位毫秒
    private long conninterval;

    // 空闲连接最大超时时间，mysql默认连接在8个小时无请求(即有线程用Connection发送了SQL)，就会自动断开
    private long freeConnectionMaxAliveTime;

}
