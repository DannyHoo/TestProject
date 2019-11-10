package com.code.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExceptionTest {

    /**
     * 线程池中的线程出现异常
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行开始");
                int i = 10 / 0;
                System.out.println(Thread.currentThread().getName() + "执行结束");
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行开始");
                System.out.println(Thread.currentThread().getName() + "执行结束");
            }
        });
        System.out.println();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行开始");
                int i = 10 / 0;
                System.out.println(Thread.currentThread().getName() + "执行结束");
            }
        }).start();
    }
}
