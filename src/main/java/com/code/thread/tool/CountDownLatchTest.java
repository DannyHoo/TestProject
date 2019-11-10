package com.code.thread.tool;

import java.util.concurrent.CountDownLatch;

/**
 * @author Danny
 * @Title: CountDownLatchTest
 * @Description: 允许一个或多个线程等待其他线程完成操作，相当于join。计数器只能使用一次，不能修改。
 * @Created on 2018-10-10 13:42:23
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        countDownLatchTest();
    }

    public static void joinTest() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread1 开始执行");
                    Thread.currentThread().sleep(2000);
                    System.out.println("Thread1 执行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread2 开始执行");
                    Thread.currentThread().sleep(3000);
                    System.out.println("Thread2 执行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Thread1 和 Thread2 执行结束");
    }

    public static void countDownLatchTest() throws InterruptedException {
        // 计数器为2，每次执行countDown()方法，计数器减1，await()方法会阻塞当前线程直到计数器为0
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread1 开始执行");
                    Thread.currentThread().sleep(2000);
                    System.out.println("Thread1 执行结束");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread2 开始执行");
                    Thread.currentThread().sleep(3000);
                    System.out.println("Thread2 执行结束");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        countDownLatch.await();
        System.out.println("Thread1 和 Thread2 执行结束");
    }
}
