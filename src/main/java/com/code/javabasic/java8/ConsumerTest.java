package com.code.javabasic.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author danny
 * @date 2020/6/22下午4:05
 * https://juejin.im/post/5d43c8a66fb9a06ade10f1d8
 */
public class ConsumerTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    //① 使用consumer接口实现方法
    public static void test1() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String task) {
                System.out.println("consumed: " + task);
            }
        };

        List<String> tasks = new ArrayList<>();
        tasks.add("Task1");
        tasks.add("Task2");
        tasks.add("Task3");

        tasks.stream().forEach(consumer);
    }

    //② 使用lambda表达式，forEach方法需要的就是一个Consumer接口
    public static void test2() {
        Consumer<String> consumer = s -> System.out.println("consumed: " + s);

        List<String> tasks = new ArrayList<>();
        tasks.add("Task1");
        tasks.add("Task2");
        tasks.add("Task3");

        tasks.stream().forEach(consumer);
    }

    //③ 使用方法引用，方法引用也是一个consumer
    public static void test3(){
        Consumer<String> consumer=System.out::println;

        List<String> tasks = new ArrayList<>();
        tasks.add("Task1");
        tasks.add("Task2");
        tasks.add("Task3");

        tasks.stream().forEach(consumer);

    }
}
