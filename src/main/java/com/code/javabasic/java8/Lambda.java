package com.code.javabasic.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danny
 * @Title: Lambda
 * @Description:
 * @Created on 2018-09-29 10:51:39
 */
public class Lambda {
    public static void main(String[] args) {

        /*new Thread(()->{
            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束");
        }).start();

        List<User> stringList=new ArrayList<>();
        stringList.add(new User("User"));
        stringList.add(new User("Lucy"));
        stringList.add(new User("Jack"));
        stringList.forEach(item->System.out.println(item.getName()));
*/

    }

    static class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }
    }
}
