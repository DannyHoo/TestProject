package com.code.javabasic.innerclass;

/**
 * @author huyuyang@lxfintech.com
 * @Title: OuterClass3
 * @Copyright: Copyright (c) 2016
 * @Description: 局部内部类
 * @Company: lxjr.com
 * @Created on 2018-08-24 15:42:46
 */
public class OuterClass3 {
    private String name = "OuterClass";
    private static int age = 25;

    public static void main(String[] args) {
        OuterClass3 outerClass3 = new OuterClass3();
        outerClass3.addAgeForInnerClass();
    }

    public void addAgeForInnerClass() {
        final int addAge = 1;

        class InnerClass {
            String name = "InnerClass";
            int age = 20;

            public void addAge(int age) {
                this.age += age;
                System.out.println("age of InnerClass:" + this.age);
            }

            public void print() {
                System.out.println("name of InnerClass:" + name);  //内部类引用自己的变量
                System.out.println("name of InnerClass:" + this.name);  //内部类引用自己的变量
                System.out.println("name of OuterClass:" + OuterClass3.this.name);  //内部类引用对应主类的同名变量
                System.out.println("age of InnerClass.addAgeForInnerClass.addAge:" + addAge);//内部类引用所在方法中的变量
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.addAge(addAge);
    }
}
