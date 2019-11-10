package com.code.thread.lock;

/**
 * @author Danny
 * @Title: NotAtomicAddTest
 * @Description:
 * @Created on 2018-09-26 16:39:05
 */
public class NotAtomicAddTest {

    private static int num=0;

    public static void main(String[] args) throws InterruptedException {
        /*MyThread thread1=new MyThread();
        MyThread thread2=new MyThread();*/
        MySynchronizedThread thread1=new MySynchronizedThread();
        MySynchronizedThread thread2=new MySynchronizedThread();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("最终计算结果："+num);
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<1000000;i++){
                num++;
            }
        }
    }

    static class MySynchronizedThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<1000000;i++){
                synchronized (NotAtomicAddTest.class){
                    num++;
                }
            }
        }
    }
}
