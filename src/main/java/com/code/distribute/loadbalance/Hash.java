package com.code.distribute.loadbalance;

/**
 * 哈希
 */
public class Hash extends BaseLoadBalance {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String sourceIp = "123.123.123." + i;
            Server server = getServer(sourceIp);
            System.out.println(sourceIp+" server: "+server.getUrl());
        }
    }

    public static Server getServer(String sourceIp) {
        Integer index = sourceIp.hashCode() % serverList.size();
        return serverList.get(index);
    }
}
