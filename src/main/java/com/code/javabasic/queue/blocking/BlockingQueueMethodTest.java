package com.code.javabasic.queue.blocking;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author danny
 * @date 2020/5/27上午9:49
 */
public class BlockingQueueMethodTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        SynchronousQueue synchronousQueue=new SynchronousQueue();
        Object object=synchronousQueue.poll(5, TimeUnit.SECONDS);

        System.out.println("finished."+ JSON.toJSONString(object));
    }
}
