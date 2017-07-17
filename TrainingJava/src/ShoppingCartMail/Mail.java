/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartMail;

import java.util.Set;



/**
 *
 * @author andreslietti
 */
public class Mail{
    
    private String mailDestination;
    private String mailOrigin;
    private String Subject;
    private String Text;
    
    public Mail(){
        
    }
    
    public Mail (String maildestination, String mailorigin, String subject, String text){
        
        this.mailDestination = maildestination;
        this.mailOrigin = mailorigin;
        this.Subject = subject;
        this.Text = text;
        
    }

    public String getMailDestination() {
        return mailDestination;
    }

    public String getMailOrigin() {
        return mailOrigin;
    }

    public String getSubject() {
        return Subject;
    }

    public String getText() {
        return Text;
    }

    public void setMailDestination(String mailDestination) {
        this.mailDestination = mailDestination;
    }

    public void setMailOrigin(String mailOrigin) {
        this.mailOrigin = mailOrigin;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    
    
}
