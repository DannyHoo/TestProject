package com.code.javabasic.innerclass;

/**
 * @Title: OuterClass2
 * @Description: 静态内部类
 * @Created on 2018-08-24 14:23:59
 */
public class OuterClass2 {
    private String name = "OuterClass";
    private static int age = 25;

    public static void main(String[] args) {
        OuterClass2 outerClass = new OuterClass2();
        InnerClass innerClass = new InnerClass();//可以直接通过对应主类访问静态内部类
    }

    public OuterClass2() {
        System.out.println("OuterClass Init……");
    }

    protected static class InnerClass {
        private static String name = "InnerClass"; //静态内部类可以定义对应主类属性相同的变量；可以定义静态变量
        private static int age = 25;

        public InnerClass() {
            System.out.println("InnerClass Init……");
        }
    }
}
