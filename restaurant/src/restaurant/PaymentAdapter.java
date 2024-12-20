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


public class PaymentAdapter {
    private ThirdPartyPaymentSystem thirdPartyPayment;

    public PaymentAdapter(ThirdPartyPaymentSystem thirdPartyPayment) {
        this.thirdPartyPayment = thirdPartyPayment;
    }

    

    public void processPayment(Order order) {
        thirdPartyPayment.makePayment(order);
    }
}
