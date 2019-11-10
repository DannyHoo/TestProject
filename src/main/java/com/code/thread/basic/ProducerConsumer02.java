package com.code.thread.basic;

/**
 * @author Danny
 * @Title: ProducerConsumer02
 * @Description:
 * @Created on 2019-02-17 23:42:15
 */
public class ProducerConsumer02 {

    private static Object lock=new Object();
    private static int count=0;

    public static void main(String[] args) {
        Thread producer=new Thread(new Producer());
        Thread consumer=new Thread(new Consumer());
        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable{
        @Override
        public void run() {
            while (true){
                synchronized (lock){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while(count==1){
                        System.out.println("已经有一个商品，等待消费");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("已经生产一个商品");
                    lock.notify();
                }
            }
        }
    }

    static class Consumer implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (lock){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (count==0){
                        System.out.println("没有商品，等待生产");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println("消费了一个商品");
                    lock.notify();
                }
            }
        }
    }
}
