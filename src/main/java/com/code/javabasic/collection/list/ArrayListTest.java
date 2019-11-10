package com.code.javabasic.collection.list;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {


        ArrayList list=new ArrayList(3);
        list.add("Object1");
        list.add("Object2");
        list.add(1,"Object1-2");
        list.add("Object3");
        //list.add(null);
        System.out.println(JSON.toJSONString(list));

        list.remove(null);
        list.remove("Object2");
        list.remove(1);
        System.out.println(JSON.toJSONString(list));

        list.get(1);
        list.size();

        String [] strings={"Object1","Object2"};
        String[] strings1=Arrays.copyOf(strings,5);
        System.out.println(strings1.length);
        for(int i = 0; i < strings1.length; i++)
            System.out.print(strings1[i] + " ");
    }
}
