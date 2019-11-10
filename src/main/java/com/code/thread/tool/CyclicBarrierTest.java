package com.code.thread.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Danny
 * @Title: CyclicBarrierTest
 * @Description: 让一组线程到达一个屏障时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。计数器可以用reset()方法重置。例：野外郊游，走一公里互相等，人到期了继续走。
 * @Created on 2018-10-10 14:15:14
 */
public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程1已到达屏障");
                    cyclicBarrier.await();//线程1已到达屏障，等待
                    System.out.println("线程1重新开始执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程2执行耗时比较长，麻烦线程1等待一会");
                    Thread.currentThread().sleep(5000);
                    System.out.println("线程2已到达屏障");
                    cyclicBarrier.await();//线程2已到达屏障，等待
                    System.out.println("线程2重新开始执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
