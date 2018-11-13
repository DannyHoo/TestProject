package com.danny.test.code.javabasic.innerclass;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ExecOrderTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-08-24 14:31:44
 */
public class ExecOrderTest {
    private static String className="ExecOrderTest";

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }

    public static void main(String[] args) {
        System.out.println(ExecOrderTest.className);
    }
}
