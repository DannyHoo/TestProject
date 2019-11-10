package com.code.designpattern.creational.builder.example1;

/**
 * @author
 * @Title: BeerAndChickenRollMealBuilder
 *
 * @Description:
 *
 * @Created on 2017-09-18 14:18:28
 */
public class BeerAndChickenRollMealBuilder extends MealBuilder {

    public void buildFood() {
        meal.setFood("chicken roll");
    }

    public void buildDrink() {
        meal.setDrink("beer");
    }
}
