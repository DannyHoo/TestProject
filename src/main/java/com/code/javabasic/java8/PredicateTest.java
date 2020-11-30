package com.code.javabasic.java8;

import java.util.function.Predicate;

/**
 * @author danny
 * @date 2020/6/22下午4:01
 */
public class PredicateTest {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Predicate<Integer> judgeAdult = new Predicate<Integer>() {
            @Override
            public boolean test(Integer age) {
                if (age >= 18) {
                    return true;
                }
                return false;
            }
        };

        System.out.println(judgeAdult.test(18));
    }

    public static void test2() {
        Predicate<Integer> judgeAdult = (t) -> t >= 18;

        System.out.println(judgeAdult.test(18));
    }


}
