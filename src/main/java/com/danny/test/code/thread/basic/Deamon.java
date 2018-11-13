package com.danny.test.code.thread.basic;

/**
 * @author Danny
 * @Title: Deamon
 * @Description: 设置thread为deamon线程，当执行完thread.start();之后，Java虚拟机中已经没有非Deamon线程，虚拟机即将退出，所以不会执行finally中的语句
 * @Created on 2018-09-20 15:12:06
 */
public class Deamon {

    public static void main(String[] args) {
        Deamon deamon = new Deamon();
        Thread thread = new Thread(deamon.new DeamonThread(), "DeamonThread");
        thread.setDaemon(true);
        thread.start();
    }

    class DeamonThread implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " is finished");
            }
        }
    }
}
