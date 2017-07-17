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
public class ContextTypePayment {
    private StrategyTypePayment strategy;

    public ContextTypePayment (StrategyTypePayment strategyTP){
        this.strategy = strategyTP;
    }

    public List<String> executeStrategy(String paymentMethod){
        return strategy.counter(paymentMethod);
    }
}
