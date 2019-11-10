package com.code.thread.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Danny
 * @Title: SemaphoreTest
 * 用来控制同时访问特定资源的线程数量。
 * @Description:
 * @Created on 2018-10-10 15:23:33
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT=10;
    private static ExecutorService threadPool= Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore=new Semaphore(2);

    public static void main(String[] args) {
        for (int i=0;i<THREAD_COUNT;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {https://qnm.hunliji.com/FgujTsBNTG3Kpt-mk7NSXwEiKcjN
                    try {
                        semaphore.acquire();
                        System.out.println("save data");
                        Thread.currentThread().sleep(2000);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
