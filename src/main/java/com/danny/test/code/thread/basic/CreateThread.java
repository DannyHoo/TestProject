package com.danny.test.code.thread.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Danny
 * @Title: CreateThread
 * @Description: 创建线程
 * @Created on 2018-09-20 14:41:21
 */
public class CreateThread {

    private int cycleNum=10;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThread createThread=new CreateThread();

        Thread1 thread1=createThread.new Thread1();
        thread1.start();

        Thread thread2=new Thread(createThread.new Thread2());
        thread2.start();

        Thread3 thread3=createThread.new Thread3();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(thread3);
        new Thread(futureTask).start();
        System.out.println("Thread3 execute result:"+futureTask.get());
    }

    class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < cycleNum; i++) {
                System.out.println("Thread1 is running");
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread1 is finished");
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < cycleNum; i++) {
                System.out.println("Thread2 is running");
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread2 is finished");
        }
    }

    class Thread3 implements Callable {
        @Override
        public Object call() throws InterruptedException {
            int count = 0;
            for (int i = 0; i < cycleNum; i++) {
                System.out.println("Thread3 is running");
                count++;
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread3 is finished");
            return count;
        }
    }
}
