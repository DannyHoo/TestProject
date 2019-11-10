package com.code.javabasic.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    //被代理的目标类
    private Object targetObject;

    //创建代理
    public Object createProxyInstance(Object targetObject){
        this.targetObject=targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object object=method.invoke(targetObject,args);
        doAfter();
        return object;
    }

    private void doBefore(){
        System.out.println("before");
    }

    private void doAfter(){
        System.out.println("after");
    }
}
