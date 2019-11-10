package com.code.jvm.classload;

/**
 * @author Danny
 * @Title: Parent
 *
 * @Description:
 *
 * @Created on 2018-08-07 17:31:34
 */
public class Parent {
    static {
        System.out.println("Parent-静态代码块执行");
    }

    public Parent() {
        System.out.println("Parent-构造方法执行");
    }

    {
        System.out.println("Parent-非静态代码块执行");
    }
}
