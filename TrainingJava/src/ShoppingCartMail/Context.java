/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartMail;

import java.util.List;

/**
 *
 * @author andreslietti
 */
public class Context {
    private Strategy strategy;
    
    public Context (Strategy strategy){
        this.strategy = strategy;
    }
    
    public List<String> executeStrategy(String paymentMethod){
        return strategy.Counter(paymentMethod);
    }
}
