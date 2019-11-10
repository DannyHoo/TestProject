package com.code.javabasic.collection.comparable;

import com.alibaba.fastjson.JSON;
import com.code.utils.DateUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList=new ArrayList<User>();
        userList.add(new User().setName("Danny2").setBirthday(DateUtils.parseDateNewFormat("2019-01-02 12:12:12")));
        userList.add(new User().setName("Danny3").setBirthday(DateUtils.parseDateNewFormat("2019-01-03 12:12:12")));
        userList.add(new User().setName("Danny1").setBirthday(DateUtils.parseDateNewFormat("2019-01-01 12:12:12")));

        System.out.println("排序前：");
        System.out.println(JSON.toJSONString(userList.get(0)));
        System.out.println(JSON.toJSONString(userList.get(1)));
        System.out.println(JSON.toJSONString(userList.get(2)));

        Collections.sort(userList);

        System.out.println("排序后：");
        System.out.println(JSON.toJSONString(userList.get(0)));
        System.out.println(JSON.toJSONString(userList.get(1)));
        System.out.println(JSON.toJSONString(userList.get(2)));
    }
}
