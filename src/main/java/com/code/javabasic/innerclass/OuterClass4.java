package com.code.javabasic.innerclass;

/**
 * @Title: OuterClass4
 * @Description:
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
