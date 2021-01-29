package com.code.distribute.loadbalance;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 加权轮询
 */
public class WeightRoundRobin extends BaseLoadBalance {

    private final static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            WeightServer server = getServer();
            System.out.println(server.getUrl());
        }
    }

    public static WeightServer getServer() {
        if (atomicInteger.get() >= weightServerList.size()) {
            atomicInteger.set(0);
        }
        return weightServerList.get(atomicInteger.getAndIncrement());
    }
}
