package com.danny.test.code.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Danny
 * @Title: ReentrantReadWriteLockTest
 * @Description:
 * @Created on 2018-11-01 22:05:09
 */
public class ReentrantReadWriteLockTest {

    private static Map<String,Object> map=new HashMap<String,Object>();
    private static ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    private static Lock readLock=readWriteLock.readLock();
    private static Lock writeLock= readWriteLock.writeLock();

    public static final Object get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public static final Object put(String key,Object object){
        writeLock.unlock();
        try {
            return map.put(key,object);
        }finally {
            writeLock.unlock();
        }
    }

    public static final void clear(){
        writeLock.lock();
        try {
            map.clear();
        }finally {
            writeLock.unlock();
        }
    }

}
