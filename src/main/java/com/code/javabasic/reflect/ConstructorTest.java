package com.code.javabasic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<ConstructorTest> constructor=ConstructorTest.class.getConstructor();
        ConstructorTest constructorTest=constructor.newInstance();
    }
}
