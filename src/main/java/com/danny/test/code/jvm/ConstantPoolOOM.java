package com.danny.test.code.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ConstantPoolOOM
 * @Copyright: Copyright (c) 2016
 * @Description: 模拟方法去内存溢出(jdk1.6可以实现)
 * -XX:Permsize=10M -XX:MaxPermsize=10M 大小写区分
 * @Company: lxjr.com
 * @Created on 2018-06-08 17:20:50
 */
public class ConstantPoolOOM {

    public static void main(String[] args) {
        /*List<String> stringList=new ArrayList<>();
        int i=0;
        while (true){
            stringList.add(String.valueOf(i++).intern());
        }*/
        internTest();
    }

    public static void internTest(){
        String str1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);

        String str2=new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }
}
