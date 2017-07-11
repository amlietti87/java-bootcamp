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
public class CreditCard extends PaymentMethod{

    @Override
    public String getMethod() {
        return "Credit Card";
    }

    @Override
    public String getRequieremts() {
        return "Please enter your Name and Credit Card Number";
    }
    
}
