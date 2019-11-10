package com.code.javabasic.innerclass;

/**
 * @author huyuyang@lxfintech.com
 * @Title: OuterClass1
 * @Copyright: Copyright (c) 2016
 * @Description: 成员内部类
 * @Company: lxjr.com
 * @Created on 2018-08-24 14:13:40
 */
public class OuterClass1 {
    private String name = "OuterClass";
    private static int age = 25;

    public static void main(String[] args) {
        OuterClass1 outerClass = new OuterClass1();
        InnerClass innerClass = outerClass.new InnerClass(); //访问成员内部类需要用对应主类的对象进行访问
        innerClass.innerPrint();
    }

    public OuterClass1() {
        System.out.println("OuterClass init……");
    }

    public void print() {
        System.out.println("OuterClass print()");
    }

    protected class InnerClass {
        //private static String name="InnerClass"; //局部内部类不能定义静态变量/方法（Inner classes cannot have static declarations）
        private String name = "InnerClass"; //局部内部类可以定义对应主类属性相同的变量

        public InnerClass() {
            System.out.println("InnerClass init……");
        }

        public void print() {
            System.out.println("InnerClass print()");
        }

        public void innerPrint() {
            System.out.println("name of InnerClass:" + name);  //内部类引用自己的变量
            System.out.println("name of InnerClass:" + this.name);  //内部类引用自己的变量
            System.out.println("name of OuterClass:" + OuterClass1.this.name);  //内部类引用对应主类的同名变量
            System.out.println("age of OuterClass:" + age);  //内部类引用对应主类的变量
            print();   //内部类调用自己与主类同名的方法
            OuterClass1.this.print(); //内部类调用对应主类的同名方法
        }
    }
}
