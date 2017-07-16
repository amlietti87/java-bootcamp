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
public class MailInvoker {
    
    MailCommand mailcommand;
    
    public MailInvoker(MailCommand mailcommand){
        this.mailcommand = mailcommand;
    }
    
    public void setMailCommand (MailCommand mailcommand){
        this.mailcommand = mailcommand;
    }
    
    public void invoke(Mail mail){
        
        mailcommand.execute(mail);
        
    }
    
}
