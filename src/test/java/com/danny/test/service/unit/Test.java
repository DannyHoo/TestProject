package com.danny.test.service.unit;

import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Test
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-16 17:22:55
 */
public class Test {

    @org.junit.Test
    public void test() {
        BigDecimal bigDecimal1 = new BigDecimal(100);
        BigDecimal bigDecimal2 = new BigDecimal("100.00");
        boolean compareResult = bigDecimal1.equals(bigDecimal2);
        Assert.assertTrue(compareResult);
    }

    @org.junit.Test
    public void test2() {
        String a="";
        String b=a.toString();
        List<Person> personList=new ArrayList<>();
        personList.add(new Person(1,"danny1"));
        personList.add(new Person(2,"danny2"));
        personList.add(new Person(3,"danny3"));
        personList.add(new Person(4,"danny4"));
        List<Person> persons=getList(personList);
        boolean flag=personList.contains(persons.get(1));
        Assert.assertTrue(flag);
    }

    private List<Person> getList(List<Person> personList) {
        List<Person> persons=new ArrayList<>();
        for (Person p:personList){
            persons.add(p);
        }
        return persons;
    }


}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}