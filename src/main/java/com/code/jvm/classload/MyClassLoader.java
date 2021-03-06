package com.code.jvm.classload;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Danny
 * @Title: MyClassLoader
 *
 * @Description:
 *
 * @Created on 2018-08-08 14:00:30
 */
public class MyClassLoader extends ClassLoader{

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

    public static void main(String[] args) {

    }
}
