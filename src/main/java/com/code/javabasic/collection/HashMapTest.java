package com.code.javabasic.collection;

import com.alibaba.fastjson.JSONObject;
import com.code.javabasic.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Title: HashMapTest
 * @Description:
 * @Created on 2018-08-22 16:20:42
 */
public class HashMapTest {

    public static void main(String[] args) throws IOException, InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        reflection();

        long start = System.currentTimeMillis();
        Map concurrentMap=new ConcurrentHashMap();
        concurrentMap.put(11, "1");
        concurrentMap.put(21, "2");
        concurrentMap.put(31, "3");
        concurrentMap.put(41, "4");
        concurrentMap.get(11);

        Map hashtable=new Hashtable();
        hashtable.put(11, "1");

        Map map = new HashMap();
        map.put(11, "1");
        map.put(21, "2");
        map.put(31, "3");
        map.put(41, "4");
        System.out.println(map.get(null));

        System.out.println("耗时" + (System.currentTimeMillis() - start));

        Map syncMap= Collections.synchronizedMap(map);

        nodeTest();
    }

    public static String index() throws IOException {
        String jsonStr = "";
        try {
            FileReader fr = new FileReader("/Users/dannyhoo/data/hash.rtf");//需要读取的文件路径
            BufferedReader br = new BufferedReader(fr);
            jsonStr = br.readLine();
            br.close();
            fr.close();     //关闭文件流
        } catch (IOException e) {
            System.out.println("指定文件不存在");//处理异常
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map = JSONObject.parseObject(jsonStr);
        return "Hash Collision ~";
    }

    public static void nodeTest() throws InterruptedException {
        Node<String, Object> firstNode = new Node<>("1", new Object());
        Node<String, Object> secondNode = new Node<>("2", new Object());
        Node<String, Object> thirdNode = new Node<>("3", new Object());
        firstNode.next = secondNode;
        secondNode.next = firstNode;

        Node tempNode = firstNode;
        while (tempNode!=null) {
            System.out.println("Node:"+tempNode.getKey());
            Thread.sleep(500);
            tempNode = tempNode.next;
        }
    }

    public static void reflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, String> map = new HashMap<String, String>();
        String key = "key";
        Integer val = new Integer(1);
        Method m = HashMap.class.getDeclaredMethod("put", new Class[] { Object.class, Object.class });
        m.invoke(map, key, val);

        System.out.println(map); //{key=1}
        System.out.println(map.get(key)); // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
    }
}
