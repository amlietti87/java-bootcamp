/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

/**
 *
 * @author andreslietti
 */
public class Cash extends PaymentMethod {

    @Override
    public String getPaymentMethod() {
        return "Cash";
    }

    @Override
    public String getRequieremts() {
        return "Thanks";
    }

    
}
