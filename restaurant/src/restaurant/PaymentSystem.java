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


public class PaymentSystem {
    private static PaymentSystem instance;

    private PaymentSystem() {}

    public static PaymentSystem getInstance() {
        if (instance == null) {
            instance = new PaymentSystem();
        }
        return instance;
    }

    public void processPayment(Order order) {
        System.out.println("Payment processed for order: " + order);
    }

    void processPayment(String paymentDetails) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
