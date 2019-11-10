package com.code.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Danny
 * @Title: LockSupportTest
 * @Description:
 * @Created on 2018-10-09 10:29:52
 */
public class LockSupportTest {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        //lockSupport();
        compareLockSupportWithWaitNotify();
    }

    /**
     * 相比较于wait/notify优点：
     * 1、不需要在同步代码块中执行
     * 2、调用unpark之前不需要睡眠（不需要考虑park和unpark的执行顺序问题，只要unpark代码在park之后就行）
     *
     * @throws InterruptedException
     */
    public static void lockSupport() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"准备等待");
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+"重新执行");
            }
        },"子线程");
        thread.start();

        Thread.currentThread().sleep(2000);
        System.out.println("两秒钟后，主线程控制子线程重新执行");
        LockSupport.unpark(thread);
    }

    /**
     * 执行这个方法会报如下异常，原因是Object的wait、notify方法必须在同步代码块中（synchronized{}）执行
     * Exception in thread "main" java.lang.IllegalMonitorStateException
     * at java.lang.Object.notify(Native Method)
     * at com.danny.test.code.thread.lock.LockSupportTest.main(LockSupportTest.java:31)
     *
     * @throws InterruptedException
     */
    public static void compareLockSupportWithWaitNotify() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println(Thread.currentThread().getName()+"准备等待");
                        lock.wait();
                        System.out.println(Thread.currentThread().getName()+"重新执行");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"子线程");
        thread.start();

        Thread.currentThread().sleep(2000);
        System.out.println("两秒钟后，主线程控制子线程重新执行");

        synchronized (lock) {
            lock.notify();
        }
    }
}
