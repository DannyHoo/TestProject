package com.danny.test.code.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Danny
 * @Title: ReentrantLockTest
 * @Description:
 * @Created on 2018-09-26 14:05:25
 */
public class ReentrantLockTest2 {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread lockClass = new Thread(new LockClass(),"LockClass");
        Thread tryLockClass = new Thread(new TryLockClass(),"TryLockClass");

        lockClass.start();
        tryLockClass.start();

        /*Thread lockInterruptiblyClass = new Thread(new LockInterruptiblyClass(),"LockInterruptiblyClass");
        Thread alwaysHoldLockClass = new Thread(new AlwaysHoldLockClass(),"AlwaysHoldLockClass");
        alwaysHoldLockClass.start();
        lockInterruptiblyClass.start();
        lockClass.start();

        Thread.currentThread().sleep(20000);
        lockInterruptiblyClass.interrupt();
        lockClass.interrupt();*/
    }

    static class LockClass implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("LockClass 等待获取锁");
                reentrantLock.lock();
                reentrantLock.lock();
                System.out.println("LockClass 重复获取锁");
                try {
                    System.out.println("LockClass 通过lock获取到了锁并持有5秒钟");
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                reentrantLock.unlock();
                reentrantLock.unlock();
                System.out.println("LockClass 执行结束");
            }
        }
    }

    static class TryLockClass implements Runnable {
        @Override
        public void run() {
            try {
                if (reentrantLock.tryLock(6000, TimeUnit.MILLISECONDS)) {
                    System.out.println("TryLockClass 通过tryLock(3000,TimeUnit.MILLISECONDS)获取到了锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                System.out.println("TryLockClass 执行结束");
            }

        }
    }

    static class LockInterruptiblyClass implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("LockInterruptiblyClass 等待获取锁");
                reentrantLock.lockInterruptibly();
                System.out.println("LockInterruptiblyClass 通过lockInterruptibly获取到了锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                System.out.println("LockInterruptiblyClass 执行结束");
            }
        }
    }

    static class AlwaysHoldLockClass implements Runnable {
        @Override
        public void run() {
            try {
                reentrantLock.lock();
                System.out.println("AlwaysHoldLockClass 持续占有锁……");
                while (true) {

                }
            } finally {
                reentrantLock.unlock();
                System.out.println("AlwaysHoldLockClass 执行结束");
            }
        }
    }
}

