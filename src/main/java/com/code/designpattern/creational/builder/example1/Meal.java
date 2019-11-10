package com.code.designpattern.creational.builder.example1;

/**
 * @author
 * @Title: Meal
 *
 * @Description: 创建的套餐
 *
 * @Created on 2017-09-18 14:16:47
 */
public class Meal {
    private String food; //主食
    private String drink; //饮品

    public String getFood() {
        return food;
    }

    public Meal setFood(String food) {
        this.food = food;
        return this;
    }

    public String getDrink() {
        return drink;
    }

    public Meal setDrink(String drink) {
        this.drink = drink;
        return this;
    }
}
