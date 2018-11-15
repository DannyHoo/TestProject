package com.danny.test.code.thread.threadpool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Danny
 * @Title: ThreadPoolTest
 * @Description: 工作原理:
 * （参考：https://blog.csdn.net/lfdfhl/article/details/40739093）
 * 线程池的工作中主要涉及到:corePoolSize,workQueue,maximumPoolSize,RejectedExecutionHandler
 * 它们的调用原理:
 * 1 当线程池中线程数量小于corePoolSize则创建线程,并处理请求
 * 2 当线程池中线程数量等于corePoolSize则把请求放入workQueue中,线程池中的的空闲线程就从workQueue中取任务并处理
 * 3 当workQueue已满存放不下新入的任务时则新建线程入池,并处理请求;
 * 如果线程池中线程数大于maximumPoolSize则用RejectedExecutionHandler使用一定的策略来做拒绝处理
 * <p>
 * 在该机制中还有一个keepAliveTime,文档描述如下:
 * when the number of threads is greater than the core,
 * this is the maximum time that excess idle threads will wait for new tasks before terminating.
 * 它是什么意思呢？
 * 比如线程池中一共有5个线程,其中3个为核心线程(core)其余两个为非核心线程.
 * 当超过一定时间(keepAliveTime)非核心线程仍然闲置(即没有执行任务或者说没有任务可执行)那么该非核心线程就会被终止.
 * 即线程池中的非核心且空闲线程所能持续的最长时间,超过该时间后该线程被终止.
 * @Created on 2018-10-11 20:30:18
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        Thread[] threads = getThreads(9);
        Callable[] callables = getCallables(9);

        //fixedThreadPoolExecute(3, threads);
        fixedThreadPoolSubmit(3, callables);
        //singleThreadPoolExecute(threads);
        //cachedThreadPoolExecute(threads);
        //scheduledThreadPoolExecute(5, threads);
        //singleScheduledThreadPoolExecute(threads);
        //customThreadPoolExecute(2, 3, 2, TimeUnit.MICROSECONDS, 5, threads);
    }

    // 固定大小线程池，执行顺序无序
    // 当要加入的池的线程（或者任务）超过池最大尺寸时候，则入此线程池需要排队等待。一旦池中有线程完毕，则排队等待的某个线程会入池执行
    public static void fixedThreadPoolExecute(int poolSize, Thread[] threads) {
        ExecutorService threadPool = null;
        try {
            threadPool = Executors.newFixedThreadPool(poolSize);
            for (Thread thread : threads) {
                threadPool.execute(thread);
            }
        } finally {
            if (threadPool != null) threadPool.shutdown();
        }
    }

    public static void fixedThreadPoolSubmit(int poolSize, Callable[] threads) {
        ExecutorService threadPool = null;
        try {
            threadPool = Executors.newFixedThreadPool(poolSize);
            for (Callable callable : threads) {
                Future future = threadPool.submit(callable);
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (threadPool != null) threadPool.shutdown();
        }
    }

    // 单线程线程池，执行顺序有序
    // 当要加入的池的线程（或者任务）超过池最大尺寸时候，则入此线程池需要排队等待。一旦池中有线程完毕，则排队等待的某个线程会入池执行
    public static void singleThreadPoolExecute(Thread[] threads) {
        ExecutorService threadPool = null;
        try {
            threadPool = Executors.newSingleThreadExecutor();
            for (Thread thread : threads) {
                threadPool.execute(thread);
            }
        } finally {
            if (threadPool != null) threadPool.shutdown();
        }
    }

    // 可变线程池
    // 创建一个可以根据需要动态创建线程的线程池，但是在【之前构造的线程可用时】将重用它们
    public static void cachedThreadPoolExecute(Thread[] threads) {
        ExecutorService threadPool = null;
        try {
            threadPool = Executors.newCachedThreadPool();
            for (Thread thread : threads) {
                threadPool.execute(thread);
            }
        } finally {
            if (threadPool != null) threadPool.shutdown();
        }
    }

    // 延迟线程池
    // 可以指定多长时间后执行任务
    public static void scheduledThreadPoolExecute(int poolSize, Thread[] threads) {
        ScheduledExecutorService threadPool = null;
        try {
            threadPool = Executors.newScheduledThreadPool(poolSize);
            for (int i = 0; i < threads.length; i++) {
                if (i % 2 == 0) {
                    threadPool.execute(threads[i]);
                } else {
                    threadPool.schedule(threads[i], 1000, TimeUnit.MILLISECONDS);
                }
            }
        } finally {
            if (threadPool != null) threadPool.shutdown();
        }
    }

    // 单任务延迟线程池
    // 可以指定多长时间后执行任务
    public static void singleScheduledThreadPoolExecute(Thread[] threads) {
        ScheduledExecutorService threadPool = null;
        try {
            threadPool = Executors.newSingleThreadScheduledExecutor();
            for (int i = 0; i < threads.length; i++) {
                if (i % 2 == 0) {
                    threadPool.execute(threads[i]);
                } else {
                    threadPool.schedule(threads[i], 1000, TimeUnit.MILLISECONDS);
                }
            }
        } finally {
            if (threadPool != null) threadPool.shutdown();
        }
    }

    //自定义线程池
    //2, 3, 2, TimeUnit.MICROSECONDS,5
    //线程过多时会抛出java.util.concurrent.RejectedExecutionException异常
    public static void customThreadPoolExecute(
            int corePoolSize,
            int maximumPoolSize,
            long keepAliveTime,
            TimeUnit unit,
            int workQueueSize,
            Thread[] threads) {
        //创建线程等待队列
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(workQueueSize);
        ThreadPoolExecutor threadPool = null;
        try {
            threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, blockingQueue);
            for (int i = 0; i < threads.length; i++) {
                threadPool.execute(threads[i]);
            }
        } finally {
            if (threadPool != null) threadPool.shutdown();
        }
    }

    static class MyThread implements Runnable {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " 正在执行……");
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Thread[] getThreads(int threadNum) {
        if (threadNum < 1) return new Thread[]{};
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(new MyThread("线程" + (i + 1)));
        }
        return threads;
    }

    private static Callable[] getCallables(int callableNum) {
        if (callableNum < 1) return new Callable[]{};
        Callable[] callables=new Callable[callableNum];
        for (int i=0;i<callableNum;i++){
            callables[i]=new Callable() {
                @Override
                public Object call() throws Exception {
                    return new Random().nextInt(100);
                }
            };
        }
        return callables;
    }
}
