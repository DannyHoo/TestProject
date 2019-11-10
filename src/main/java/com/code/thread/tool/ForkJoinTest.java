package com.code.thread.tool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;

public class ForkJoinTest {
    private static AtomicLong threadNum=new AtomicLong(0);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start =System.currentTimeMillis();

        ForkJoinPool forkJoinPool=new ForkJoinPool();
        CountTask countTask=new CountTask(1L,100000000L);
        Future<Long> future=forkJoinPool.submit(countTask);
        System.out.println(future.get());

        System.out.println("耗时："+(System.currentTimeMillis()-start) +" 最多线程数："+threadNum);
    }

    /**
     * 美[rɪˈkɜːrsɪv]
     */
    static class CountTask extends RecursiveTask<Long> {
        private static final Long THRESHOLD = 100000000L; // 最大值和最小值的差 不超过这个阈值就直接计算
        private Long start;
        private Long end;

        public CountTask(Long start, Long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            threadNum.addAndGet(1);
            long sum = 0;
            if (end - start <= THRESHOLD) {
                for (Long i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                // 如果任务大于阈值，就分割成两个任务计算
                Long middle = (start + end) / 2;
                CountTask leftTask = new CountTask(start, middle);
                CountTask rightTask = new CountTask(middle + 1, end);
                // 执行子任务
                leftTask.fork();
                rightTask.fork();
                // 等待子任务执行完，获取结果
                Long leftResult = leftTask.join();
                Long rightResult = rightTask.join();
                sum = leftResult + rightResult;
            }
            return sum;
        }
    }
}
