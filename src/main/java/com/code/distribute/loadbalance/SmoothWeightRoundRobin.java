package com.code.distribute.loadbalance;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 平滑加权轮询
 * https://blog.csdn.net/claram/article/details/90272318
 */
public class SmoothWeightRoundRobin extends BaseLoadBalance {


    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            SmoothWeightServer server = getServer();
            System.out.println(server.getUrl());
        }
    }

    public static SmoothWeightServer getServer() {
        //【查找出当前权重最大的对象】
        SmoothWeightServer maxWeightServer = getMaxWeightServer(smoothWeightServerList);

        //【重新计算权重】
        // 1、计算所有对象原始权重之和 weightSum
        Integer originalWeightSum = getOriginalWeightSum(smoothWeightServerList);
        // 2、被筛选的权重最大的对象 当前权重=当前权重-所有对象原始权重之和weightSum
        maxWeightServer.setCurrentWeight(maxWeightServer.getCurrentWeight()-originalWeightSum);
        // 3、经历过一次访问后，所有对象的 当前权重=原始权重+当前权重
        smoothWeightServerList.stream().forEach(smoothWeightServer -> {
            smoothWeightServer.setCurrentWeight(smoothWeightServer.getCurrentWeight()+smoothWeightServer.getOriginalWeight());
        });

        return maxWeightServer;
    }

    private static Integer getOriginalWeightSum(List<SmoothWeightServer> smoothWeightServerList) {
        Integer originalWeightSum = smoothWeightServerList.stream().collect(Collectors.summingInt(SmoothWeightServer::getOriginalWeight));
        return originalWeightSum;
    }

    // 查找出当前权重最大的对象
    private static SmoothWeightServer getMaxWeightServer(List<SmoothWeightServer> smoothWeightServerList) {
        SmoothWeightServer server = null;
        for (SmoothWeightServer smoothWeightServer : smoothWeightServerList) {
            if (server == null) {
                server = smoothWeightServer;
            } else if (smoothWeightServer.getCurrentWeight() > server.getCurrentWeight()) {
                server = smoothWeightServer;
            }
        }
        return server;
    }


    public volatile static Map<String, SmoothWeightServer> serverMap = new TreeMap<>();

    static {
        serverMap.put("192.168.1.1", new SmoothWeightServer("192.168.1.1", 1, 1));
        serverMap.put("192.168.1.2", new SmoothWeightServer("192.168.1.2", 2, 2));
        serverMap.put("192.168.1.3", new SmoothWeightServer("192.168.1.3", 3, 3));
        serverMap.put("192.168.1.4", new SmoothWeightServer("192.168.1.4", 4, 4));
    }

    public static String getServerUrl() {
        /// 原始权重之和
        Integer weightSum = 0;
        /// 最大当前权重对象
        SmoothWeightServer maxWeightServer = null;

        /// 计算最大当前权重对象，同时求原始权重之和
        Iterator<String> iterator = serverMap.keySet().iterator();
        while (iterator.hasNext()) {
            SmoothWeightServer smoothWeightServer = serverMap.get(iterator.next());
            if (smoothWeightServer != null) {
                weightSum += smoothWeightServer.getOriginalWeight();
                if (maxWeightServer == null) {
                    maxWeightServer = smoothWeightServer;
                }
                if (smoothWeightServer.getCurrentWeight() > maxWeightServer.getCurrentWeight()) {
                    maxWeightServer = smoothWeightServer;
                }
            }
        }

        /**
         * 重新调整 currentWeight 权重：
         * maxWeightServer.currentWeight -= weightSum
         * 每个 smoothWeightServer.currentWeight += smoothWeightServer.originalWeight
         */
        if (maxWeightServer == null) {
            return "";
        }
        maxWeightServer.setCurrentWeight(maxWeightServer.getCurrentWeight() - weightSum);

        iterator = serverMap.keySet().iterator();
        while (iterator.hasNext()) {
            SmoothWeightServer smoothWeightServer = serverMap.get(iterator.next());
            if (smoothWeightServer != null) {
                smoothWeightServer.setCurrentWeight(smoothWeightServer.getCurrentWeight() + smoothWeightServer.getOriginalWeight());
            }
        }

        return maxWeightServer.getUrl();
    }

    public static void main1(String[] args) {
        for (int i = 0; i < 10; i++) {
            String server = getServerUrl();
            System.out.println(server);
        }
    }
}
