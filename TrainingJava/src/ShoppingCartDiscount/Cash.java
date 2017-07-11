/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartDiscount;

import java.util.List;

/**
 *
 * @author andreslietti
 */
public class Cash extends PaymentMethod {

    @Override
    public String getMethod() {
        return "Cash";
    }

    @Override
    public String getRequieremts() {
        return "Thanks";
    }

    @Override
    public double getDiscount(List<Product> listProducts) {
        double max = listProducts.get(0).getPrice(), total = 0;
        
        for (int i = 0; i < listProducts.size(); i++) {
            total += listProducts.get(i).getPrice();            
        }
        
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getPrice() > max) {
                max = listProducts.get(i).getPrice();
            }
        }
        
        total = total - (max*0.9);
        return total;
    }

    

    

    

    
}
