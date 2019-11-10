package com.code.javabasic.basicclass;

public class StringTest {

    /**
     * String s=new String("xyz")究竟创建String Object分为两种情况：
     * 如果String常理池中，已经创建"xyz"，则不会继续创建，此时只创建了一个对象new String("xyz")；
     * 如果String常理池中，没有创建"xyz"，则会创建两个对象，一个对象的值是"xyz"，一个对象new String("xyz")。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        String str=new String("1");

        String str1="abc";
        String str2="abc";
        String str3=String.valueOf("abc");//跟Integer一样，valueOf会先从常量池中获取
        String str4=new String("abc");
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str1==str4);
    }

}
