package com.code.javabasic.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public  Object getProxy(Class clazz) {
        // 设置需要为其创建子类的父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        // 通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        doBefore();
        // 通过代理类调用其父类中的方法
        Object result = methodProxy.invokeSuper(obj, args);
        doAfter();
        return result;
    }

    private void doBefore() {
        System.out.println("before");
    }

    private void doAfter() {
        System.out.println("after");
    }

}
