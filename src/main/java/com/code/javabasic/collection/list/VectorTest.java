package com.code.javabasic.collection.list;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class VectorTest {
    public static void main(String[] args) {
        List arrayList=new ArrayList();
        List synchronousList=Collections.synchronizedList(arrayList);
        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();

        Vector vector=new Vector();
        vector.add("a");
        vector.get(0);
        vector.remove(0);

        Stack stack=new Stack();

        synchronousList.add("Object1");
        System.out.println(JSON.toJSONString(synchronousList));

    }
}
