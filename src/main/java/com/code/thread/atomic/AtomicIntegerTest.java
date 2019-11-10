package com.code.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Danny
 * @Title: AtomicIntegerTest
 * @Description:
 * @Created on 2018-10-10 10:41:15
 */
public class AtomicIntegerTest {

    private static int num=0;
    private static AtomicInteger atomicInteger=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        atomicIntegerTest();
    }

    private static void testInteger() throws InterruptedException {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    num++;
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    num++;
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(num);
    }

    private static void atomicIntegerTest() throws InterruptedException {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    atomicInteger.addAndGet(1);
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    atomicInteger.addAndGet(1);
                    atomicInteger.incrementAndGet();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(atomicInteger.get());
    }
}
