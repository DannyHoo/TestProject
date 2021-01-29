package com.code.distribute.loadbalance;

/**
 * 随机
 */
public class Random extends BaseLoadBalance {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Server server = getServer();
            System.out.println(server.getUrl());
        }
    }

    public static Server getServer() {
        Integer index = new java.util.Random().nextInt(serverList.size());
        return serverList.get(index);
    }

}
