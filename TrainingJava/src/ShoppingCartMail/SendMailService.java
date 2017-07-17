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
public class SendMailService implements ProductCommand {
    
    @Override
    public void Execute(Mail mail) {
        System.out.println("Sending mail to: " + mail.getMailDestination() + "\n" +
                           "from: " + mail.getMailOrigin() + "\n" +
                           "subject: " + mail.getSubject() + "\n" +
                           "message: " + mail.getText());
    }

    
}
