/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartCounter;

/**
 *
 * @author andreslietti
 */
import java.util.List;

/**
 *
 * @author andreslietti
 */
public class CreditCard extends PaymentMethod{

private static final double DISCOUNT = 0.1;
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }

    @Override
    public String getRequieremts() {
        return "Please enter your Name and Credit Card Number";
    }


    @Override
    public double getDiscount(List<Product> listProducts) {
        double total = 0;
        for (int i = 0; i < listProducts.size(); i++) {
            total += listProducts.get(i).getPrice();
        }

        total = total - (total * DISCOUNT);
        return total;

    }

}

