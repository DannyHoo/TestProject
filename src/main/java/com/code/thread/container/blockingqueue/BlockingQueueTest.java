package com.code.thread.container.blockingqueue;

import java.util.concurrent.*;

/**
 * @author Danny
 * @Title: BlockingQueueTest
 * @Description:
 * @Created on 2019-02-23 11:12:52
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(0x7fffffff);

        ArrayBlockingQueue arrayBlockingQueue= new ArrayBlockingQueue(1);
        LinkedBlockingQueue linkedBlockingQueue=new LinkedBlockingQueue();
        SynchronousQueue blockingQueue3=new SynchronousQueue();
        PriorityBlockingQueue blockingQueue4=new PriorityBlockingQueue();
        DelayQueue delayQueue=new DelayQueue();

        Object object=new Object();
        arrayBlockingQueue.add(object);
        arrayBlockingQueue.offer(object);
        arrayBlockingQueue.put(object);
        arrayBlockingQueue.put(object);
        arrayBlockingQueue.offer(object,1000,TimeUnit.SECONDS);
        arrayBlockingQueue.take();

        linkedBlockingQueue.add(object);
        linkedBlockingQueue.offer(object);
        linkedBlockingQueue.put(object);
        linkedBlockingQueue.offer(object,1000,TimeUnit.SECONDS);
        linkedBlockingQueue.remove();
        linkedBlockingQueue.poll();
        linkedBlockingQueue.take();
        linkedBlockingQueue.poll(1000,TimeUnit.SECONDS);



    }
}
