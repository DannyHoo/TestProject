package com.code.javabasic.queue.blocking.delayqueue.demo1;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author danny
 * @date 2020/5/25下午4:21
 */
@Data
public class DelayTask<T extends Runnable> implements Delayed {
    private final long time;
    private final T task; // 任务类，也就是之前定义的任务类

    public DelayTask(long time, T task) {
        this.time = System.nanoTime()+time;
        this.task = task;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTask other = (DelayTask) o;
        long diff = time - other.time;
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int hashCode() {
        return task.hashCode();
    }
}
