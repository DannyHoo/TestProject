package com.danny.test.code.thread.basic;

/**
 * @author Danny
 * @Title: StopThread
 * @Description: 正确停止线程
 * @Created on 2018-09-20 17:27:03
 */
public class StopThread {

    public static void main(String[] args) throws InterruptedException {
        WorkThread workThread=new StopThread().new WorkThread();
        Thread thread=new Thread(workThread,"WorkThread");
        thread.start();

        Thread.currentThread().sleep(5000);
        //workThread.shutdown();
        thread.interrupt();
    }

    class WorkThread implements Runnable{
        private long i=0;
        private volatile boolean on=true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("calculate finished,i="+i);
        }

        public void shutdown(){
            on=false;
        }
    }
}
