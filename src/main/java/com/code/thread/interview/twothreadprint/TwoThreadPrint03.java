package com.code.thread.interview.twothreadprint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @date 2020/10/29下午4:30
 * 两个线程交替打印
 * 线程1：1 2 3 4 5 6 7 8 9 ……
 * 线程2： A B C D E F G H I ……
 * <p>
 * 用Condition
 */
public class TwoThreadPrint03 {

    private static Lock lock=new ReentrantLock();
    private static Condition condition1=lock.newCondition();
    private static Condition condition2=lock.newCondition();
    private static Condition condition3=lock.newCondition();

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 26; i++) {
                synchronized (lock) {
                    System.out.println(i);
                    condition1.notify();
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

    static class Thread3 implements Runnable {
        @Override
        public void run() {
            char a = 'a';
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
