package com.code.javabasic.queue.blocking.delayqueue;

import com.code.utils.DateUtils;

import java.util.concurrent.*;

/**
 * @author danny
 * @date 2020/5/25下午2:17
 */
public class DelayQueueTest {
    public static void main(String[] args) {
        // 创建延迟队列
        DelayQueue<Message> queue = new DelayQueue<Message>();
        // 添加延时消息 message1 延时3s
        Message message1 = new Message(1, "hello", 5 * 1000);
        // 添加延时消息 message2 延时10s
        Message message2 = new Message(3, "world", 10 * 1000);
        Message message3 = new Message(2, "hello world", 20 * 1000);
        // 将延时消息放到延时队列中
        queue.offer(message1);
        queue.offer(message2);
        queue.offer(message3);
        // 启动消费线程，消费添加到延时队列中的消息（当任务到了延期时间的时候）
        ExecutorService executor = new ThreadPoolExecutor(
                1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        System.out.println(DateUtils.getNewFormatDateString(DateUtils.getNowDate()) + "线程池开启");
        executor.execute(new Consumer(queue));
        executor.shutdown();
        System.out.println(DateUtils.getNewFormatDateString(DateUtils.getNowDate()) + "线程池关闭");
    }
}
