/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartMail;

/**
 *
 * @author andreslietti
 */
public class SendMailExecute {
    
    public void execute(ProductCommand sendmail, Mail mail){
        sendmail.Execute(mail);
    }
    
}
