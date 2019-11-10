package com.code.designpattern.creational.builder.example1;

/**
 * @author
 * @Title: MealBuilder
 *
 * @Description:
 *
 * @Created on 2017-09-18 14:17:01
 */
public abstract class MealBuilder {

    protected Meal meal=new Meal();

    public Meal getMeal() {
        return meal;
    }

    public MealBuilder setMeal(Meal meal) {
        this.meal = meal;
        return this;
    }

    public abstract void buildFood();

    public abstract void buildDrink();
}
