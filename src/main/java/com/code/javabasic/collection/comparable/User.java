package com.code.javabasic.collection.comparable;

import java.util.Date;

public class User implements Comparable<User>{

    private int id;
    private String name;
    private Date birthday;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public int compareTo(User o) {
        if (o!=null && o.birthday!=null){
            return birthday.compareTo(o.birthday);
        }
        return 0;
    }
}
