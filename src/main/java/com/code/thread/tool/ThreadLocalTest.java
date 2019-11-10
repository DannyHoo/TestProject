package com.code.thread.tool;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Danny
 * @Title: ThreadLocalTest
 * @Description:
 * @Created on 2018-09-21 14:28:48
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                ThreadLocalTest threadLocalTest=new ThreadLocalTest();
                System.out.println(threadLocalTest.getThreadId());
                System.out.println(threadLocalTest.getThreadName());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                ThreadLocalTest threadLocalTest=new ThreadLocalTest();
                System.out.println(threadLocalTest.getThreadId());
                System.out.println(threadLocalTest.getThreadName());
            }
        }.start();

        ThreadLocal threadLocal=new ThreadLocal();
        threadLocal.set(1);
        threadLocal.remove();
    }


    private ThreadLocal<Map> threadLocal=new ThreadLocal<Map>(){
        @Override
        protected Map initialValue() {
            Map map=new HashMap();
            map.put("threadName",Thread.currentThread().getName());
            map.put("threadId",Thread.currentThread().getId());
            return map;
        }
    };

    private String getThreadName(){
        return String.valueOf(threadLocal.get().get("threadName"));
    }

    private long getThreadId(){
        return Long.valueOf(String.valueOf(threadLocal.get().get("threadId")));
    }

}
