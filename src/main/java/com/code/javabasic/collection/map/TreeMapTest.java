package com.code.javabasic.collection.map;

import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {

        //TreeMap map = new TreeMap(new KeyComparator());
        TreeMap map = new TreeMap();
        map.put("key2", "value2");
        map.put("key1", "value1");
        map.put("key3", "value3");
        /*map.put(new ClassA(),"1");*/

        map.get("key2");
        Set<Map.Entry> set = map.entrySet();
        Iterator<Map.Entry> iteratorTreeMap = set.iterator();
        while (iteratorTreeMap.hasNext()) {
            Map.Entry entry = iteratorTreeMap.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println(key + ":" + value);
        }
    }

    static class ClassA {
    }

    static class KeyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}
