/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartCounter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreslietti
 */
public class CounterTypePayment implements StrategyTypePayment {

    List <String> CounterTP = new ArrayList<String>();
    @Override

    public List<String> counter (String paymentMethod) {

        switch(paymentMethod){

            case "Credit Card":
                CounterTP.add(paymentMethod);
                break;

            case "PayPal":
                CounterTP.add(paymentMethod);
                break;

            case "Cash":
                CounterTP.add(paymentMethod);
                break;

            default:
                break;

        }
        return CounterTP;
    }

}

