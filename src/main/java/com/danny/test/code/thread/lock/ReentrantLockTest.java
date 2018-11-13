package com.danny.test.code.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Danny
 * @Title: ReentrantLockTest
 * @Description:
 * @Created on 2018-09-26 14:05:25
 */
public class ReentrantLockTest {

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new CounterA());
        Thread thread2 = new Thread(new CounterA());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("num=" + num);
    }

    static class CounterA implements Runnable {
        @Override
        public void run() {
            try {
                reentrantLock.lock();
                for (int i = 0; i < 1000000; i++) {
                    num++;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    static class CounterB implements Runnable {
        @Override
        public void run() {
            if (reentrantLock.tryLock()) {
                try {
                    for (int i = 0; i < 100000000; i++) {
                        num++;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }

        }
    }
}
