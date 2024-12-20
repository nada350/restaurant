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
public class MenuItemFactory {
    public MenuItem createMenuItem(String type) {
        switch (type.toLowerCase()) {
            case "appetizer":
                return new Appetizer("Spring Rolls");
            case "maincourse":
                return new MainCourse("Steak");
            case "dessert":
                return new Dessert("Cheesecake");
            default:
                throw new IllegalArgumentException("Invalid Menu Item Type");
        }
    }

    MenuItem cloneMenuItem(String itemName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    MenuItem createMenuItem(String toLowerCase, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
