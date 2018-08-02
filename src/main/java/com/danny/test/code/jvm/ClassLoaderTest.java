package com.danny.test.code.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ClassLoaderTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * 虚拟机中存在了两个ClassLoaderTest类，一个是有系统应用程序类加载器加载的，另一个是由我们自定义的类加载器加载的，虽然都来自于同一个Class文件，但依然是两个独立的类。
 *
 * @Company: lxjr.com
 * @Created on 2018-07-19 20:28:41
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myClassLoader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is=getClass().getResourceAsStream(fileName);
                    if (is==null){
                        return super.loadClass(name);

                    }
                    byte[] b=new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch (IOException e){
                    throw new ClassNotFoundException();
                }
            }
        };

        Object object=myClassLoader.loadClass("com.danny.test.code.jvm.ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof com.danny.test.code.jvm.ClassLoaderTest);
    }
}
