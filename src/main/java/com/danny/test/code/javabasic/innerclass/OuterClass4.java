package com.danny.test.code.javabasic.innerclass;

/**
 * @author huyuyang@lxfintech.com
 * @Title: OuterClass4
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-08-24 17:17:56
 */
public class OuterClass4 {

    public static void main(String[] args) {
        print(178);
    }

    public static void print(final int height) {
        AbstractClass abstractClass = new AbstractClass() {

            @Override
            public void print() {
                System.out.println(name + "' age is " + age + ",his height is" + height);
            }
        };
        abstractClass.print();
    }
}
