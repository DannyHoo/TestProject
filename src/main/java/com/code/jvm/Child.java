package com.code.jvm;

import java.util.ArrayList;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Child
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-08-07 17:23:00
 */

public class Child extends Parent {
    private static int staticValue = 123;
    private int noStaticValue=456;

    static {
        System.out.println("Child-静态代码块执行");
    }

    public Child() {
        System.out.println("Child-构造方法执行");
    }

    {
        System.out.println("Child-非静态代码块执行");
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}
