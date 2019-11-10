package com.code.javabasic.collection.map;


import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap =new ConcurrentHashMap();
        concurrentHashMap.put("1","1");
        concurrentHashMap.get("1");

    }
}
