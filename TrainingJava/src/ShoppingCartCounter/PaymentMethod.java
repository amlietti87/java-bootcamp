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
public abstract class PaymentMethod {

    public abstract String getPaymentMethod();
    public abstract String getRequieremts();
    public abstract double getDiscount(List<Product> listProducts);

}

