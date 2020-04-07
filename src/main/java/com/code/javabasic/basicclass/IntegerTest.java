package com.code.javabasic.basicclass;

import com.code.utils.DateUtils;

import java.lang.reflect.Field;
import java.time.Period;
import java.time.ZoneId;
/**
 * @Title: IntegerTest
 * @Description: Java中Integer和String作为函数参数传递的方式是传值
 * https://mp.weixin.qq.com/s/xf1USfUFBGYZZB68gbFHqg
 * @Created on 2018-07-25 10:27:27
 */
public class IntegerTest {

    public static void main(String[] args) {

        Period period = Period.between(DateUtils.parseDateNewFormat("2019-11-03 12:23:31").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                DateUtils.parseDateNewFormat("2019-11-07 15:23:31").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        int activityDays = period.getDays();


        /*Integer i=Integer.valueOf(1);

        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println(i1.equals(i2));
        System.out.println(i1 == i2);

        Integer i3 = new Integer(129);
        Integer i4 = new Integer(129);
        System.out.println(i3.equals(i4));
        System.out.println(i3 == i4);*/

        Integer a = 1;
        Integer b = 2;
        System.out.println("before warp : a=" + a + ";b=" + b);
        swap(a, b);
        System.out.println("after warp : a=" + a + ";b=" + b);
    }

    public static void changeValue(Integer i){

    }

    //传值、传址测试
    //https://www.jianshu.com/p/0f8fa37b13bd
    public static void swap(Integer a, Integer b) {
        /*Integer temp=a;
        a=b;
        b=temp;*/
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            //先把a、b的value取出来，否则在-128~127之间的值会被覆盖
            /*int tempA=a.intValue();
            int tempB=b.intValue();
            field.setInt(a,tempA);
            field.setInt(b,tempB);*/
            int temp = a.intValue();
            field.setInt(a, b.intValue());
            field.setInt(b, temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void maxMinValue() {
        System.out.println("Max Value of Integer:" + Integer.MAX_VALUE);
        System.out.println("Min Value of Integer:" + Integer.MIN_VALUE);
    }
}
