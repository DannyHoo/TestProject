package com.danny.test.code.thread.deadlock;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DeadLock
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-08-23 22:58:13
 */
public class DeadLock {
    private static String A = "A";
    private static String B = "B";

    private static Lock lockA = new DeadLock().new Lock();

    public static void main(String[] args) {
        deadLockTest();
    }

    private static void deadLockTest() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    System.out.println(Thread.currentThread().getName() + "获取到A锁");
                    try {
                        Thread.currentThread().sleep(2000);
                        synchronized (B) {
                            System.out.println(Thread.currentThread().getName() + "获取到B锁");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    System.out.println(Thread.currentThread().getName() + "获取到B锁");
                    try {
                        Thread.currentThread().sleep(2000);
                        synchronized (A) {
                            System.out.println(Thread.currentThread().getName() + "获取到A锁");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    class Lock {
    }


}
