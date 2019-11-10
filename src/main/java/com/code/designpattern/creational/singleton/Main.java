package com.code.designpattern.creational.singleton;


import com.code.designpattern.creational.singleton.frame.AbstractSinngleton;
import com.code.designpattern.creational.singleton.frame.Singleton2;
import com.code.designpattern.creational.singleton.frame.Singleton6;

import java.util.ArrayList;
import java.util.List;

import static sun.jvm.hotspot.runtime.PerfMemory.start;

/**
 * @author
 * @Title: Main
 *
 * @Description:
 *
 * @Created on 2017-06-24 13:57:47
 */
public class Main {
    final static List<AbstractSinngleton> sinngletonList = new ArrayList<AbstractSinngleton>();

    public static void main(String[] args) {
        try {
            testSingleton2AndSingleton3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程安全的懒汉模式和双重校验锁模式测试
     */
    public static void testSingleton2AndSingleton3() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        List<Thread> threads2 = getThreads2();
        List<Thread> threads6 = getThreads6();

        runThread(threads6);
        joinThread(threads6);

        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    public static List<Thread> getThreads2() {
        List<Thread> threadList = new ArrayList<Thread>();
        for (int i = 0; i < 1000; i++) {
            threadList.add(new Thread() {
                public void run() {
                    sinngletonList.add(Singleton2.getInstance());
                }
            });
        }
        return threadList;
    }

    public static void runThread(List<Thread> threads){
        for (Thread t : threads) {
            t.run();
        }
    }

    public static void joinThread(List<Thread> threads) throws InterruptedException {
        for (Thread t : threads) {
            t.join();
        }
    }

    public static List<Thread> getThreads6() {
        List<Thread> threadList = new ArrayList<Thread>();
        for (int i = 0; i < 1000; i++) {
            threadList.add(new Thread() {
                public void run() {
                    sinngletonList.add(Singleton6.getInstance());
                }
            });
        }
        return threadList;
    }
}
