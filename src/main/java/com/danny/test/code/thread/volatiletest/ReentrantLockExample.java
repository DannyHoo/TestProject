package com.danny.test.code.thread.volatiletest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Danny
 * @Title: ReentrantLockExample
 * @Description:
 * @Created on 2018-09-18 21:34:26
 */
public class ReentrantLockExample {

    int a=0;
    ReentrantLock reentrantLock=new ReentrantLock();

    public void writer(){
        reentrantLock.lock();
        try {
            a++;
        }finally {
            reentrantLock.unlock();
        }
    }

    public void reader(){
        reentrantLock.lock();
        try {
            int i=a;
            System.out.println("i"+i);
        }finally {
            reentrantLock.unlock();
        }
    }
}
