package com.code.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Danny
 * @Title: TwinsLock
 * @Description:
 * @Created on 2019-02-20 20:40:54
 */
public class TwinsLock {
    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {
        public Sync(int count) {
            if (count <= 0) throw new IllegalArgumentException("锁的数量必须大于0");
            setState(count);
        }

        public int tryAcquireShared(int acquireCount) {
            for (; ; ) {
                int currentState = getState();
                int newState = currentState - acquireCount;
                if (newState< 0 || compareAndSetState(currentState, newState)) {
                    return newState;
                }
            }
        }

        public boolean tryReleaseShared(int releaseCount) {
            for (; ; ) {
                int currentState = getState();
                int newState = currentState + releaseCount;
                if (compareAndSetState(currentState, newState)) {
                    return true;
                }
            }
        }
    }

    public void lock() {
        sync.tryAcquireShared(1);
    }

    public void unlock() {
        sync.tryReleaseShared(1);
    }

    public static void main(String[] args) {
        TwinsLock twinsLock=new TwinsLock();
        ExecutorService threadPool= Executors.newFixedThreadPool(3);
        threadPool.submit(new Thread(new MyThread(twinsLock)));
        threadPool.submit(new Thread(new MyThread(twinsLock)));
        threadPool.submit(new Thread(new MyThread(twinsLock)));
        threadPool.shutdown();
    }

    static class MyThread implements Runnable{
        TwinsLock twinsLock;

        public MyThread(TwinsLock twinsLock) {
            this.twinsLock = twinsLock;
        }

        @Override
        public void run() {
            twinsLock.lock();
            System.out.println(Thread.currentThread().getName()+" 成功获取锁");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            twinsLock.unlock();
            System.out.println(Thread.currentThread().getName()+" 成功释放锁");
        }
    }
}
