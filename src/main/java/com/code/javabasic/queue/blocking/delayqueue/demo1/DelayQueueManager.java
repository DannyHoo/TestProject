package com.code.javabasic.queue.blocking.delayqueue.demo1;

import com.code.utils.PrintUtil;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author danny
 * @date 2020/5/25下午4:23
 */
public class DelayQueueManager {

    private final static int DEFAULT_THREAD_NUM = 5;
    // 固定大小线程池
    private ExecutorService executor;
    // 守护线程
    private Thread daemonThread;
    // 延时队列
    private DelayQueue<DelayTask<?>> delayQueue;
    private static final AtomicLong atomic = new AtomicLong(0);
    private final long n = 1;
    private static DelayQueueManager instance = new DelayQueueManager();

    public DelayQueueManager() {
        executor= new ThreadPoolExecutor(DEFAULT_THREAD_NUM, DEFAULT_THREAD_NUM,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        delayQueue=new DelayQueue<>();
        init();
    }

    private void init() {
        daemonThread=new Thread(()->{
            execute();
        });
        daemonThread.setName("DelayQueueMonitor");
        daemonThread.start();
    }

    private void execute() {
        while (true){
            Map<Thread,StackTraceElement[]> map=Thread.getAllStackTraces();
            PrintUtil.printWithTime("当前存活线程数量："+map.size());
            int taskNum=delayQueue.size();
            PrintUtil.printWithTime("当前延时任务数量："+taskNum);
            try{
                DelayTask<?> delayTask=delayQueue.take();
                if (delayTask!=null){
                    Runnable task=delayTask.getTask();
                    if (task!=null){
                        executor.execute(task);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void put(Runnable task,long time,TimeUnit timeUnit){
        long timeout=TimeUnit.NANOSECONDS.convert(time,timeUnit);
        DelayTask<?> delayTask=new DelayTask<>(timeout,task);
        delayQueue.put(delayTask);
    }

    public boolean delete(DelayTask task){
        return delayQueue.remove(task);
    }
}
