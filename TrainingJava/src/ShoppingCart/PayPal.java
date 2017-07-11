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
public class PayPal extends PaymentMethod {

    @Override
    public String getMethod() {
        return "PayPal";
    }

    @Override
    public String getRequieremts() {
        return "Please enter your mail and password";
    }
    
}
