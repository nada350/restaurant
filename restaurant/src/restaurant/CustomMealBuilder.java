/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author LENOVO
 */


public class CustomMealBuilder {
    private String appetizer;
    private String mainCourse;
    private String dessert;

    public CustomMealBuilder setAppetizer(String appetizer) {
        this.appetizer = appetizer;
        return this;
    }

    public CustomMealBuilder setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
        return this;
    }

    public CustomMealBuilder setDessert(String dessert) {
        this.dessert = dessert;
        return this;
    }

    public CustomMeal build() {
        return new CustomMeal(appetizer, mainCourse, dessert);
    }
}

