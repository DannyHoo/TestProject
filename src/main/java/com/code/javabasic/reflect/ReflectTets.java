package com.code.javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTets {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz=Class.forName("com.danny.test.code.javabasic.reflect.ReflectTets");
        Object object=clazz.newInstance();

        Field field=clazz.getDeclaredField("field1");
        field.setAccessible(true);
        field.set(object,"Software Engineer");
        field.setAccessible(false);
        System.out.println("ReflectTets的field1字段值："+field.get(object));

        Method method=clazz.getDeclaredMethod("print",Integer.class,String[].class);
        Object result=method.invoke(object,2,new String[]{"这是content1","这是content2"});
        System.out.println("ReflectTets的print方法调用结果："+result);
    }

    private String field1;

    public String print(Integer contentLength, String... contents){
        for (String content:contents){
            System.out.println(content);
        }
        return "SUCCESS";
    }
}
