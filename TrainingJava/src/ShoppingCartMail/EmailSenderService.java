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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSenderService {

    private final Properties properties = new Properties();

    private String password;

    private Session session;

    private void init() {

        properties.put("mail.smtp.host", "mail.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 25);
        properties.put("mail.smtp.mail.sender", "emisor@gmail.com");
        properties.put("mail.smtp.user", "usuario");
        properties.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(properties);
    }

    public void sendEmail(String Subject, String Text) {

        init();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sells@shoppingcart.com"));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress("manager@shoppingcart.com"));
            message.setSubject(Subject);
            message.setText(Text);

            // Sent mail.
            Transport t = session.getTransport("smtp");
            t.connect("sells@shoppingcart.com", "password");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception " + ex);
            return;

        }

    }

}
