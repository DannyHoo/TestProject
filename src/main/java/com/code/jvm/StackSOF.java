package com.code.jvm;

/**
 * @Title: StackSOF
 * @Description: 模拟占内存 栈溢出
 * -Xss160k
 * The stack size specified is too small, Specify at least 160k
 * @Created on 2018-06-08 15:58:17
 */
public class StackSOF {
    private int stackLength=1;
    public void doSomething(){
            stackLength++;
            doSomething();
    }
    public static void main1(String[] args) {
        StackSOF stackSOF=new StackSOF();
        try {
            stackSOF.doSomething();
        }catch (Throwable e){//注意捕获的是Throwable
            System.out.println("栈深度："+stackSOF.stackLength);
            throw e;
        }
    }

    public static void main(String[] args) {
        final StackSOF stackSOF1=new StackSOF();
        final StackSOF stackSOF2=new StackSOF();
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    stackSOF1.doSomething();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    stackSOF2.doSomething();
                }
            }).start();
        }catch (Throwable e){//注意捕获的是Throwable
            System.out.println("栈1深度："+stackSOF1.stackLength);
            System.out.println("栈2深度："+stackSOF2.stackLength);
            throw e;
        }
    }
}
