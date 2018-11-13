package com.danny.test.code.thread.basic;

/**
 * @author Danny
 * @Title: Join
 * @Description:
 * @Created on 2018-09-21 11:36:47
 */
public class Join {

    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 1000000; i++) {
            Thread thread = new Thread(new JoinThread(previous),"Thread"+i);
            thread.start();
            previous=thread;
        }
    }

    static class JoinThread implements Runnable {
        Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + " is terminate");
        }
    }
}
