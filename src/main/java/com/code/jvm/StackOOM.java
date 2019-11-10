package com.code.jvm;

/**
 * @author huyuyang@lxfintech.com
 * @Title: StackOOM
 * @Copyright: Copyright (c) 2016
 * @Description:
 * -Xmx20m -Xss2m
 * @Company: lxjr.com
 * @Created on 2018-06-08 16:18:37
 */
public class StackOOM {
    private static int threadNum = 0;

    public void doSomething() {
        /*while (true) {
        }*/
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("JVM可获得最大内存："+ Runtime.getRuntime().maxMemory()/(1024*1024)+"M");
        System.out.println("JVM已获得最大内存："+ Runtime.getRuntime().totalMemory()/(1024*1024)+"M");
        System.out.println("JVM获得的空闲内存："+ Runtime.getRuntime().freeMemory()/(1024*1024)+"M");
        final StackOOM stackOOM = new StackOOM();
        try {
            while (true) {
                threadNum++;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        stackOOM.doSomething();
                    }
                });
                thread.start();
            }
        } catch (Throwable e) {
            System.out.println("目前活动线程数量：" + threadNum);
            throw e;
        }
    }
}
