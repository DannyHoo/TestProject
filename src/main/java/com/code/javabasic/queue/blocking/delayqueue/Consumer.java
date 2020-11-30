package com.code.javabasic.queue.blocking.delayqueue;

import com.code.utils.DateUtils;

import java.util.concurrent.DelayQueue;

/**
 * @author danny
 * @date 2020/5/25下午2:16
 */
public class Consumer implements Runnable {
    // 延时队列 ,消费者从其中获取消息进行消费
    private DelayQueue<Message> queue;

    public Consumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message take = queue.take();
                System.out.println(DateUtils.getNewFormatDateString(DateUtils.getNowDate())+"消费消息id：" + take.getId() + " 消息体：" + take.getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
