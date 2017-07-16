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
public class ContextTypePayment {
    private StrategyTypePayment strategyTP;

    public ContextTypePayment (StrategyTypePayment strategyTP){
        this.strategyTP = strategyTP;
    }

    public List<String> executeStrategy(String paymentMethod){
        return strategyTP.counter(paymentMethod);
    }
}

