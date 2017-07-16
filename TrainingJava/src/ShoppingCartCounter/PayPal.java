/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartCounter;

import java.util.List;

/**
 *
 * @author andreslietti
 */

public class PayPal extends PaymentMethod {

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }

    @Override
    public String getRequieremts() {
        return "Please enter your mail and password";
    }

    @Override
    public double getDiscount(List<Product> listProducts) {
        double min = listProducts.get(0).getPrice(), total = 0;

        for (int i = 0; i < listProducts.size(); i++) {
            total += listProducts.get(i).getPrice();
        }

        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrice() < min) {
                min = listProducts.get(i).getPrice();
            }
        }

        total = total - min;
        return total;
    }

}

