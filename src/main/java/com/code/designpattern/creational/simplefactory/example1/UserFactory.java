package com.code.designpattern.creational.simplefactory.example1;

/**
 * @author
 * @Title: UserFactory
 *
 * @Description:
 *
 * @Created on 2017-06-22 10:22:53
 */
public class UserFactory {
    /**
     * 获取用户实例
     * @param userSimpleName
     * @return
     */
    public static User getUserByLevel(String userSimpleName) {
        if (Administrator.class.getSimpleName().equals(userSimpleName)) {
            return new Administrator();
        }
        if (Manager.class.getSimpleName().equals(userSimpleName)) {
            return new Manager();
        }
        if (Employee.class.getSimpleName().equals(userSimpleName)) {
            return new Employee();
        }
        return null;
    }
}
