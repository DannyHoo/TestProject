package com.danny.test.code.thread.tool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Danny
 * @Title: ExChangerTest
 * @Description: 当一个线程到达exchange调用点时，如果它的伙伴线程此前已经调用了此方法，
 * 那么它的伙伴会被调度唤醒并与之进行对象【交换】，然后各自返回。如果它的伙伴还没到达交换点，那么当前线程将会被挂起，直至伙伴线程到达——完成交换正常返回；或者当前线程被中断——抛出中断异常；又或者是等候超时——抛出超时异常。
 * @Created on 2018-10-10 15:48:42
 */
public class ExChangerTest {

    private static Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    // 校对工作：为了避免出错，A、B二人做同一工作，最后对工作结果进行校对
    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String totalNum = "100";//线程A计算结果
                System.out.println("线程A计算结果为："+totalNum);
                try {
                    String totalNumTemp = exchanger.exchange(totalNum);//阻塞直到另一个线程调用exchange()方法
                    System.out.println("A——从B线程拿到的结果为：" + totalNumTemp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String totalNum = "101";//线程B计算结果
                System.out.println("线程B计算结果为："+totalNum);
                try {
                    Thread.currentThread().sleep(3000);
                    String totalNumTemp = exchanger.exchange(totalNum);//阻塞直到另一个线程调用exchange()方法
                    System.out.println("B——从A线程拿到的结果为:" + totalNumTemp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }

}
