package com.danny.test.code.javabasic;

import java.lang.reflect.Field;

/**
 * @author huyuyang@lxfintech.com
 * @Title: IntegerTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * Java中Integer和String作为函数参数传递的方式是传值
 * https://mp.weixin.qq.com/s/xf1USfUFBGYZZB68gbFHqg
 * @Company: lxjr.com
 * @Created on 2018-07-25 10:27:27
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a=1;
        Integer b=2;
        System.out.println("before warp : a="+a+";b="+b);
        swap(a,b);
        System.out.println("after warp : a="+a+";b="+b);
    }

    public static void swap(Integer a,Integer b)  {
        /*Integer temp=a;
        a=b;
        b=temp;*/
        try {
            Field field=Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            //先把a、b的value取出来，否则在-128~127之间的值会被覆盖
            /*int tempA=a.intValue();
            int tempB=b.intValue();
            field.setInt(a,tempA);
            field.setInt(b,tempB);*/
            int temp=a.intValue();
            field.setInt(a,b.intValue());
            field.setInt(b,temp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
