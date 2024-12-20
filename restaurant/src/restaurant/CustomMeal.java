/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;





public class CustomMeal {
    private String appetizer;
    private String mainCourse;
    private String dessert;

    public CustomMeal(String appetizer, String mainCourse, String dessert) {
        this.appetizer = appetizer;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
    }

    CustomMeal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "CustomMeal [Appetizer=" + appetizer + ", Main Course=" + mainCourse + ", Dessert=" + dessert + "]";
    }

    void setAppetizer(String appetizer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setMainCourse(String mainCourse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setDessert(String dessert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

