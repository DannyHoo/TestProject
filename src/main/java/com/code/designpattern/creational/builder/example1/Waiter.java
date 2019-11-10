package com.code.designpattern.creational.builder.example1;

/**
 * @author
 * @Title: Waiter
 *
 * @Description:
 *
 * @Created on 2017-09-18 14:18:42
 */
public class Waiter {
    private MealBuilder mealBuilder;

    public Waiter(MealBuilder mealBuilder){
        this.mealBuilder=mealBuilder;
    }

    public Meal construct(){
        mealBuilder.buildFood();
        mealBuilder.buildDrink();
        return mealBuilder.getMeal();
    }

}
