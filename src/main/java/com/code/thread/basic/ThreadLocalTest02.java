package com.code.thread.basic;

/**
 * @author Danny
 * @Title: ThreadLocalTest02
 * @Description:
 * @Created on 2019-02-18 21:43:58
 */
public class ThreadLocalTest02 {
    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        Thread thread1=new Thread(new MyThread("线程1携带的数据"));
        Thread thread2=new Thread(new MyThread("线程2携带的数据"));
        thread1.start();
        thread2.start();
    }

    static class MyThread implements Runnable {
        private String content;
        public MyThread(String content) {
            this.content=content;
        }

        @Override
        public void run() {
            threadLocal.set(content);
            System.out.println("当前线程携带的数据为：" + threadLocal.get());
        }
    }
}
