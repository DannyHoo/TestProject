package com.code.designpattern.creational.simplefactory.example1;

/**
 * @author
 * @Title: Main
 *
 * @Description:
 * 权限管理，根据入参(实际情况下可能是登录方式)获得不同权限的用户
 *
 * @Created on 2017-06-22 10:39:13
 */
public class Main {
    public static void main(String[] args) {
        User user1=UserFactory.getUserByLevel(Administrator.class.getSimpleName());
        User user2=UserFactory.getUserByLevel(Manager.class.getSimpleName());
        User user3=UserFactory.getUserByLevel(Employee.class.getSimpleName());
        user1.work();
        user2.work();
        user3.work();
    }
}
