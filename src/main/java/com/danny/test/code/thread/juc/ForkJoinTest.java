package com.danny.test.code.thread.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author Danny
 * @Title: ForkJoinTest
 * @Description:
 * @Created on 2018-10-09 16:21:02
 */
public class ForkJoinTest extends RecursiveTask<Long>{
    private static final int THREADHOLD=2;
    private long start;
    private long end;

    public ForkJoinTest(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum=0;
        //如果任务足够小就计算任务
        if (end-start<=THREADHOLD){
            for (long i=start;i<=end;i++){
                sum+=i;
            }
        }else{
            long middle=(start+end)/2;
            ForkJoinTest task1=new ForkJoinTest(start,middle);
            ForkJoinTest task2=new ForkJoinTest(middle+1,end);
            //执行子任务
            task1.fork();
            task2.fork();
            //获取执行结果
            long result1=task1.join();
            long result2=task2.join();
            //合并子任务
            sum=result1+result2;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime;

        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTest forkJoinTest2=new ForkJoinTest(1,1000000000);
        startTime=System.currentTimeMillis();
        Future<Long> result=forkJoinPool.submit(forkJoinTest2);
        System.out.println(result.get());
        System.out.println("耗时："+(System.currentTimeMillis()-startTime));


        ForkJoinTest forkJoinTest1=new ForkJoinTest(1,1000000000);
        startTime=System.currentTimeMillis();
        System.out.println(forkJoinTest1.compute());
        System.out.println("耗时："+(System.currentTimeMillis()-startTime));

    }
}
