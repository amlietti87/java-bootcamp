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
public class SendMailCommand implements MailCommand {
    
    SendMailService sendmail;
    
    public SendMailCommand (SendMailService sendmail){
        this.sendmail = sendmail;
    }

    @Override
    public void execute(Mail mail) {
        sendmail.Execute(mail);
    }
    
}
