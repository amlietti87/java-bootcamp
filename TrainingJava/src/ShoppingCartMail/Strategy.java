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
public interface Strategy {
    
    public List<String> Counter(String paymentMethod);
    
}
