package com.code.designpattern.creational.builder.example1;

/**
 * @author
 * @Title: CocacolaAndHamburgerMealBuilder
 *
 * @Description:
 *
 * @Created on 2017-09-18 14:18:02
 */
public class CocacolaAndHamburgerMealBuilder extends MealBuilder{

    public void buildFood() {
        meal.setFood("hamburger");
    }

    public void buildDrink() {
        meal.setDrink("coca cola");
    }
}
