package com.danny.test.code.javabasic.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Danny
 * @Title: CollectionTest
 * GC overhead limit exceeded
 * https://blog.csdn.net/renfufei/article/details/77585294
 *
 * @Description:
 * @Created on 2018-09-26 10:57:11
 */
public class CollectionTest {
    public static void main(String[] args) {
        Map map=new HashMap();
        int i=0;
        try {
            while (true){
                map.put(i,i);
                i++;
                if (i==10000000){
                    System.out.println(map.size());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("i="+i);
            System.out.println("map.size="+map.size());
        }
    }
}
