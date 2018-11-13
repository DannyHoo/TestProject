package com.danny.test.code.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Danny
 * @Title: ConditionTest
 * @Description:
 * @Created on 2018-11-04 14:52:35
 */
public class ConditionTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static String exec = "Producer";

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(), "Producer");
        Thread consumer = new Thread(new Consumer(), "Consumer");
        producer.start();
        consumer.start();

    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (exec.equals("Consumer")){
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "获取锁，开始执行");
                    Thread.currentThread().sleep(2000);
                    exec = "Consumer";
                    condition.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (exec.equals("Producer")){
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "获取锁，开始执行");
                    Thread.currentThread().sleep(2000);
                    exec = "Producer";
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
