package com.code.javabasic.exception;

import com.code.javabasic.exception.defined.MyException;
import com.code.javabasic.exception.defined.MyIOException;
import com.code.javabasic.exception.defined.MyRuntimeException;

public class ExctptionTryCatchTest {
    public static void main(String[] args) throws MyException, MyIOException {
        fun1();
        fun2();
        fun3();
    }

    /**
     * RuntimeException及其子类不需要捕获，编译器可以成功编译
     */
    public static void fun1() {
        throw new MyRuntimeException();
    }

    public static void fun2() throws MyException {
        throw new MyException();
    }

    public static void fun3() throws MyIOException {
        throw new MyIOException();
    }
}
