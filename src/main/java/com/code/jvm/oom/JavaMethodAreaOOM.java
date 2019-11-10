package com.code.jvm.oom;

import org.assertj.core.internal.cglib.proxy.Enhancer;
import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Danny
 * @Title: JavaMethodAreaOOM
 *
 * @Description:
 *
 * @Created on 2018-07-25 18:23:00
 */
public class JavaMethodAreaOOM {
    public static void main(final String[] args){
       try {
           while (true){
               Enhancer enhancer=new Enhancer();
               enhancer.setSuperclass(JavaMethodAreaOOM.class);
               enhancer.setUseCache(false);
               enhancer.setCallback(new MethodInterceptor() {
                   @Override
                   public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                       return methodProxy.invokeSuper(o,objects);
                   }
               });
               enhancer.create();
           }
       }catch (Throwable t){
           t.printStackTrace();
       }

    }
}
