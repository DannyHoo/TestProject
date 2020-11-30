package com.code.javabasic.java8;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author danny
 * @date 2020/6/22下午5:16
 */
public class SupplierTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1(){
        System.out.println("*********** test1 ***********");
        Supplier<Integer> supplier=new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(100);
            }
        };
        System.out.println(supplier.get());
    }

    public static void test2(){
        System.out.println("*********** test2 ***********");
        Supplier<Integer> supplier=() -> new Random().nextInt(100);
        System.out.println(supplier.get());
    }

    public static void test3(){
        System.out.println("*********** test3 ***********");
        Supplier<Double> supplier=Math::random;
        System.out.println(supplier.get());
    }

}

