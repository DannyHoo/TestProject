package com.danny.test.code.thread.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * @author Danny
 * @Title: ProducerConsumer
 * @Description:
 * @Created on 2018-10-31 21:14:05
 */
public class ProducerConsumer {

    private static Object lock = new Object();
    private static List bucket = new ArrayList();
    private static int bucketCapacity = 20;

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (bucket.size() == bucketCapacity) {
                        try {
                            lock.wait();//篮子满了，停止生产
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    bucket.add("包子");
                    System.out.println("生产一个包子，现在包子数量：" + bucket.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (bucket.size() == 0) {
                        try {
                            lock.wait();//篮子空了，等待生产
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    bucket.remove(0);
                    System.out.println("消费一个包子，现在包子数量：" + bucket.size());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        }
    }

}

