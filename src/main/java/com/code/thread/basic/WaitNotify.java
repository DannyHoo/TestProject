package com.code.thread.basic;

/**
 * @author Danny
 * @Title: WaitNotify
 * @Description: 等待-通知
 * notify()：通知一个在对象上等待的线程，使其从wait()方法返回（前提是该线程获取到了对象的锁）
 * notifyAll()：通知所有等待在该对象上的线程
 * wait()：调用该方法的线程进入WAITING状态，只有等其他线程通知或中断才会返回，调用wait()方法后，会释放对象的锁
 * wait(long)、wait(long,int)，超时等待一段时间，如果没有通知就超时返回
 * @Created on 2018-09-21 10:49:55
 */
public class WaitNotify {

    private static boolean flag=true;
    private static Object lock=new Object();

    public static void main(String[] args) {
        Thread wait=new Thread(new Wait(),"WaitThread");
        Thread notify=new Thread(new Notify(),"NotifyThread");
        wait.start();
        notify.start();
    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                while (flag){
                    System.out.println(Thread.currentThread().getName()+"不满足运行条件，等待中……");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"满足运行条件，执行中……");
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"准备通知……");

                lock.notify();
                flag=false;

                System.out.println(Thread.currentThread().getName()+"通知完毕，倒数5秒……");
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
