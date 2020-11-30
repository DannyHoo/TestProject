package com.code.book.effectivejava.chapter02;

/**
 * 可变参数较多时，使用Builder来构造实例
 */
public class NutritionFacts {

    private final int servingSize;
    private final int servings;

    public static class Builder {
        private final int servingSize;
        private final int servings;

        private int calories;
        private int fat;
        private int carbohydrate;
        private int sodium;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }
    }

    public NutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
    }

    public static void main(String[] args) {
        Builder builder=new Builder(100,80);
        builder.calories(10);
        NutritionFacts nutritionFacts=new NutritionFacts(builder);

    }
}
