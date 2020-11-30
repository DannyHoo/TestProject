package com.code.thread.interview.twothreadprint;

import java.util.concurrent.locks.LockSupport;

/**
 * @date 2020/10/29下午4:30
 * 两个线程交替打印
 * 线程1：1 2 3 4 5 6 7 8 9 ……
 * 线程2： A B C D E F G H I ……
 * <p>
 * 用wait、notify
 */
public class TwoThreadPrint02 {

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
    }

    private static Object lock = new Object();

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 26; i++) {
                synchronized (lock) {
                    System.out.println(i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Thread2 implements Runnable {
        @Override
        public void run() {
            char a = 'A';
            for (int i = 0; i < 26; i++) {
                synchronized (lock) {
                    System.out.println(a);
                    a++;
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
