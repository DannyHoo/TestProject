package com.code.distribute.loadbalance;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮询
 *
 */
public class RoundRobin extends BaseLoadBalance {

    private final static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Server server = getServer();
            System.out.println(server.getUrl());
        }
    }

    public static Server getServer() {
        if (atomicInteger.get() >= serverList.size()) {
            atomicInteger.set(0);
        }
        return serverList.get(atomicInteger.getAndIncrement());
    }

}
