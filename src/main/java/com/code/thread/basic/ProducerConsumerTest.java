package com.code.thread.basic;

public class ProducerConsumerTest {
    private static Object lock=new Object();
    private volatile boolean flag=false;//库存是否充足

    public static void main(String[] args) {
        Producer producer=new ProducerConsumerTest().new Producer();
        Consumer consumer=new ProducerConsumerTest().new Consumer();
        new Thread(consumer).start();
        new Thread(producer).start();
    }

    class Producer implements Runnable{
        @Override
        public void run(){
            while(true){
                synchronized(lock){
                    while (flag){
                        System.out.println("Producer：库存充足，待消费");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Producer：库存不足，已补充");
                    flag=true;
                    lock.notify();
                }
            }
        }
    }

    class Consumer implements Runnable{
        @Override
        public void run(){
            while(true){
                synchronized(lock){
                    while (!flag){
                        System.out.println("Consumer：库存不足，待补充");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Consumer：库存充足，已消费");
                    flag=false;
                    lock.notify();
                }
            }
        }
    }
}
