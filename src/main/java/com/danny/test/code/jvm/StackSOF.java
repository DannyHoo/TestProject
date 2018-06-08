package com.danny.test.code.jvm;

/**
 * @author huyuyang@lxfintech.com
 * @Title: StackSOF
 * @Copyright: Copyright (c) 2016
 * @Description: 模拟占内存 栈溢出
 * -Xss160k
 * The stack size specified is too small, Specify at least 160k
 * @Company: lxjr.com
 * @Created on 2018-06-08 15:58:17
 */
public class StackSOF {

    private int stackLength=1;

    public void doSomething(){
            stackLength++;
            doSomething();
    }

    public static void main(String[] args) {
        StackSOF stackSOF=new StackSOF();
        try {
            stackSOF.doSomething();
        }catch (Throwable e){//注意捕获的是Throwable
            System.out.println("栈深度："+stackSOF.stackLength);
            throw e;
        }
    }
}
