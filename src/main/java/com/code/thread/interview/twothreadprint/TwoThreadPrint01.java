package com.code.thread.interview.twothreadprint;

import java.util.concurrent.locks.LockSupport;

/**
 * @date 2020/10/29下午4:30
 * 两个线程交替打印
 * 线程1：1 2 3 4 5 6 7 8 9 ……
 * 线程2： A B C D E F G H I ……
 * <p>
 * 用LockSupport
 */
public class TwoThreadPrint01 {

    static Thread thread1 = null;
    static Thread thread2 = null;
    static Thread thread3 = null;

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        threeThreadPrint();
    }

    /**
     * 两个线程交替打印
     * 线程1：1 2 3 4 5 6 7 8 9 ……
     * 线程2： A B C D E F G H I ……
     *
     * @throws InterruptedException
     */
    public static void twoThreadPrint() throws InterruptedException {
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 26; i++) {
                    System.out.println(i);
                    LockSupport.unpark(thread2);
                    LockSupport.park();
                }
            }
        }, "thread1");

        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                char a = 'A';
                for (int i = 0; i < 26; i++) {
                    LockSupport.park();
                    System.out.println(a);
                    a++;
                    LockSupport.unpark(thread1);
                }
            }
        }, "thread2");

        // 当线程1先执行，线程2后执行时，系统会卡住（线程1先执行到LockSupport.park();线程二开始执行LockSupport.park();）
        // thread1.start();
        // thread2.start();

        // 让线程2先执行，线程1后执行时，就会正常执行
        thread2.start();
        Thread.sleep(10);
        thread1.start();
    }

    /**
     * 三个线程交替打印
     * 线程1：1 2 3 4 5 6 7 8 9 ……
     * 线程2： A B C D E F G H I ……
     * 线程3：  a b c d d f g h i ……
     */
    public static void threeThreadPrint() throws InterruptedException {
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 26; i++) {
                    System.out.println(i);
                    LockSupport.unpark(thread2);
                    LockSupport.park();
                }
            }
        }, "thread1");

        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                char a = 'A';
                for (int i = 0; i < 26; i++) {
                    LockSupport.park();
                    System.out.println(a);
                    a++;
                    LockSupport.unpark(thread3);
                }
            }
        }, "thread2");

        thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                char a = 'a';
                for (int i = 0; i < 26; i++) {
                    LockSupport.park();
                    System.out.println(a);
                    a++;
                    LockSupport.unpark(thread1);
                }
            }
        }, "thread3");

        // 让线程2先执行，线程1后执行时，就会正常执行
        thread2.start();
        thread3.start();
        Thread.sleep(10);
        thread1.start();
    }
}
