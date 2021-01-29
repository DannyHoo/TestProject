package com.code.distribute.loadbalance;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 加权随机
 */
public class WeightRandom extends BaseLoadBalance{

    private final static List<String> serverList = new ArrayList<>();

    //统计结果
    private final static Map<String,AtomicInteger> statisticsMap=new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 6000; i++) {
            WeightServer server = getServer();
            statistics(server,statisticsMap);//统计结果
            System.out.println(server.getUrl());
        }
        System.out.println("result:\n"+ JSON.toJSONString(statisticsMap));
    }

    public static WeightServer getServer() {
        return weightServerList.get(new java.util.Random().nextInt(weightServerList.size()));
    }

    private static void statistics(WeightServer server, Map<String, AtomicInteger> statisticsMap) {
        AtomicInteger atomicInteger= statisticsMap.get(server.getUrl());
        if (atomicInteger==null){
            statisticsMap.put(server.getUrl(),new AtomicInteger(1));
        }else{
            atomicInteger.getAndIncrement();
        }
    }
}
