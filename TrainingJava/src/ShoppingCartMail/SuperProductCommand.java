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
public class SuperProductCommand implements ProductCommand {
    
    private List<ProductCommand> list = new ArrayList<ProductCommand>();
    
    public void addCommand (ProductCommand command){
        list.add(command);
    }
    
    @Override
    public void Execute(Mail mail) {
        list.forEach((t)->t.Execute(mail));
    }
    
   
    
}
