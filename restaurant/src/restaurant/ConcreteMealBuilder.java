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
public class ConcreteMealBuilder extends CustomMealBuilder {
    private CustomMeal meal = new CustomMeal();

    public void addAppetizer(String appetizer) {
        meal.setAppetizer(appetizer);
    }

    public void addMainCourse(String mainCourse) {
        meal.setMainCourse(mainCourse);
    }

    public void addDessert(String dessert) {
        meal.setDessert(dessert);
    }

    @Override
    public CustomMeal build() {
        return meal;
    }
}
