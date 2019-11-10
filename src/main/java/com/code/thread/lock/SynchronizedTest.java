package com.code.thread.lock;

/**
 * https://blog.csdn.net/u010842515/article/details/65443084
 */
public class SynchronizedTest {

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        final SynchronizedTest synchronizedTest2 = new SynchronizedTest();
        final SynchronizedTest synchronizedTest3 = new SynchronizedTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedTest1.fun1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedTest2.fun2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedTest3.fun3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 锁的是SynchronizedTest.class对象
     *
     */
    public synchronized static void fun1() throws InterruptedException {
        System.out.println("fun1");
        Thread.sleep(100000);
    }

    /**
     * 锁的是SynchronizedTest.class对象
     *
     * @throws InterruptedException
     */
    public synchronized static void fun2() throws InterruptedException {
        System.out.println("fun2");
        Thread.sleep(100000);
    }

    /**
     * 所得是SynchronizedTest的实例对象
     * @throws InterruptedException
     */
    public synchronized  void fun3() throws InterruptedException {
        System.out.println("fun3");
        Thread.sleep(100000);
    }
}
