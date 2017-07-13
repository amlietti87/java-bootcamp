/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartMail;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreslietti
 */
public class CounterTypePayment implements Strategy {
    
    List <String> Counter = new ArrayList<String>();
    @Override
    
    public List<String> Counter (String paymentMethod) {
        
        switch(paymentMethod){
            
            case "Credit Card":
                Counter.add(paymentMethod);
                break;
            
            case "PayPal":
                Counter.add(paymentMethod);
                break;
                
            case "Cash":
                Counter.add(paymentMethod);
                break;
                
            default:
                break;
            
        }
        return Counter;
    }
    
}
