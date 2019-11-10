package com.code.javabasic.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMap {
    public static void main(String[] args) {
        Map map=new HashMap();

        //类似于为传入的map创建一个Map的代理，实现了所有Map的方法，执行每个map的方法的时候加锁
        map=Collections.synchronizedMap(map);

    }
}
