package com.code.jvm;

/**
 * @author huyuyang@lxfintech.com
 * @Title: VolatileNotAtomicTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-07-23 19:08:53
 */
public class VolatileTest {


    public static void main(String[] args) {
        multIncrease();
    }

    /**
     * 不适合volatile的场景
     */
    private static int num = 0;

    private static void multIncrease() {
        int threadCount = 20;
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        num++;
                    }
                }
            });
            threads[i].start();
        }

        //等待所有累加线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(num);
    }


    /**
     * 适合用volatile的场景
     */
    private static boolean shutdownFlag = false;

    //线程1等待其他线程（比如线程2发送shutdown的命令）
    private static void shutdownSomething() throws InterruptedException {
        while (!shutdownFlag) {
            Thread.sleep(500);
            System.out.println("still working");
        }
        System.out.println("shutdown");
    }
    //其他线程发送shutdown命令，如果不用volatile修饰，线程1可能不会及时读取到主内存中shutdownFlag的值
    private static void notifyShutdown() {
        shutdownFlag = true;//用于及时通知其他线程
    }

}
