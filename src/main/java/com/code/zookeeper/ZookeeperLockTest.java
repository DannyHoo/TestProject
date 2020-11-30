package com.code.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author Danny
 * @Title: ZookeeperLockTest
 * @Description:
 * @Created on 2019-04-03 22:47:55
 */
public class ZookeeperLockTest {

    private static String lockPath = "/curator/lock";
    private static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("39.106.124.34:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();

    static{
        client.start();
    }

    public static void main(String[] args) throws Exception {

        final InterProcessMutex lock = getLock();

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss|SSS");

                    try {
                        lock.acquire();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String orderNo = simpleDateFormat.format(new Date());

                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println("生成的订单号是：" + orderNo);
                }
            }).start();
        }
        countDownLatch.countDown();
    }

    public static InterProcessMutex getLock() throws Exception {
        return new InterProcessMutex(client, lockPath);
    }
}
