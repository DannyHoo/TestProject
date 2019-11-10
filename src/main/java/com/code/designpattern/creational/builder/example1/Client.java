package com.code.designpattern.creational.builder.example1;

/**
 * @author
 * @Title: Client
 *
 * @Description:
 *
 * @Created on 2017-09-18 14:19:02
 */
public class Client {

    public static void main(String[] args) {
        Waiter waiter1=new Waiter(new BeerAndChickenRollMealBuilder());
        Meal meal1=waiter1.construct();

        Waiter waiter2=new Waiter(new CocacolaAndHamburgerMealBuilder());
        Meal meal2=waiter2.construct();

        System.out.println("【套餐1】主食："+meal1.getFood()+" ； 饮品："+meal1.getDrink());
        System.out.println("【套餐2】主食："+meal2.getFood()+" ； 饮品："+meal2.getDrink());
    }

}
