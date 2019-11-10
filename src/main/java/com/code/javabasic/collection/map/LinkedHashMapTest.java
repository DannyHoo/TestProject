package com.code.javabasic.collection.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap linkedHashMap=new LinkedHashMap(16,0.75f,true);
        linkedHashMap.put("key5","value5");
        linkedHashMap.put("key4","value4");
        linkedHashMap.put("key1","value1");
        linkedHashMap.put("key8","value8");

        linkedHashMap.get("key1");
        Set<Map.Entry> entrySet= linkedHashMap.entrySet();
        Iterator<Map.Entry> iterator=entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry entry=iterator.next();
            String key=(String)entry.getKey();
            String value=(String)entry.getValue();
            System.out.println(key+":"+value);
        }
        System.out.println(linkedHashMap);
    }
}
