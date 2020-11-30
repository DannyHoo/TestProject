package com.code.javabasic.queue.blocking.delayqueue.demo2;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author danny
 * @date 2020/5/27上午11:49
 */
@Data
@Accessors(chain = true)
public abstract class DelayTask<T> implements Runnable,Delayed {

    //任务执行时间
    private Date executeTime;

    protected T data;

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long result = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}
