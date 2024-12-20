/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;
import javax.swing.SwingUtilities;


/**
 *
 * @author LENOVO
 */
public class Restaurant {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
    
        MenuItemFactory menuFactory = new MenuItemFactory();
        TableFactory tableFactory = new TableFactory();
        OrderManager orderManager = OrderManager.getInstance();
        PaymentSystem paymentSystem = PaymentSystem.getInstance();

        // Example: Create menu items
        MenuItem appetizer = menuFactory.createMenuItem("appetizer");
        MenuItem mainCourse = menuFactory.createMenuItem("maincourse");

        // Example: Build a custom meal
        CustomMealBuilder mealBuilder = new CustomMealBuilder();
        CustomMeal meal = mealBuilder.setAppetizer("Soup").setMainCourse("Steak").setDessert("Cake").build();

        // Example: Process order
        Order order = new Order();
        String orderDetails = order.toString(); // Ensure Order has a proper toString() implementation
orderManager.processOrder(orderDetails);
        // Process payment
        PaymentAdapter adapter = new PaymentAdapter(new ThirdPartyPaymentSystem());
        adapter.processPayment(order);

        System.out.println("Meal: " + meal);
    }
    
}
