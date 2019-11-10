package com.code.thread.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danny
 * @Title: ProducerConsumer
 * @Description:
 * @Created on 2018-10-31 21:14:05
 */
public class ProducerConsumer01 {
    private final static Object lock=new Object();
    private final static List bucket = new ArrayList();
    private final static int bucketCapacity = 20;//篮子容量

    public static void main(String[] args) {
        Thread producer1 = new Thread(new Producer("producer_01"));
        Thread producer2 = new Thread(new Producer("producer_02"));
        Thread consumer1 = new Thread(new Consumer("consumer_01"));
        Thread consumer2 = new Thread(new Consumer("consumer_02"));
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }

    //生产者每秒钟生产1个包子
    static class Producer implements Runnable {
        private String name;
        public Producer(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock){
                    //篮子不满就生产
                    if (bucket.size()<bucketCapacity){
                        bucket.add("包子");
                        System.out.println(name+"生产一个包子，现在包子数量：" + bucket.size());
                        lock.notifyAll();
                    }else{
                        //篮子满了就等待
                        System.out.println("篮子满了，停止生产");
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

    //消费者每秒消费2个
    static class Consumer implements Runnable {
        private String name;
        public Consumer(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock){
                    if (bucket.size()>0){
                        bucket.remove(bucket.size()-1);
                        System.out.println(name+"消费一个包子，现在包子数量：" + bucket.size());
                        lock.notifyAll();
                    }else{
                        System.out.println("篮子空了，停止消费");
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

    static class InnnerClass{
        private static ProducerConsumer01 instance=new ProducerConsumer01();
    }

    public static ProducerConsumer01 getInstance(){
        return InnnerClass.instance;
    }
}

