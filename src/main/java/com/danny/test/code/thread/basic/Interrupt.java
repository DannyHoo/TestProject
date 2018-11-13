package com.danny.test.code.thread.basic;

/**
 * @author Danny
 * @Title: Interrupt
 * @Description: thread.interrupt():对该线程进行中断操作
 * thread.isInterrupted():判断该线程是否被终端
 * Thread.interrupted():对当前线程的中断标识位进行复位
 * 注意：
 * 一些声明抛出InterruptedException的方法（如sleep），在抛出异常之前，虚拟机会先将该线程中的中断标识位清除再抛出异常， 因此之后调用thread.isInterrupted()会返回false
 * @Created on 2018-09-19 14:12:55
 */
public class Interrupt {

    public static void main(String[] args) {
        Interrupt interrupt=new Interrupt();

        Thread sleepRunner=new Thread(interrupt.new SleepRunner());
        Thread workRunner=new Thread(interrupt.new WorkRunner());

        sleepRunner.start();
        workRunner.start();

        sleepRunner.interrupt();
        workRunner.interrupt();

        System.out.println("sleepRunner.isInterrupted()："+sleepRunner.isInterrupted());
        System.out.println("workRunner.isInterrupted()："+workRunner.isInterrupted());
    }

    class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class WorkRunner implements Runnable{
        @Override
        public void run() {
            while (true){
            }
        }
    }

}
