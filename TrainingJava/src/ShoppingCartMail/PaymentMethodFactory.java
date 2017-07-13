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
public class PaymentMethodFactory {

    public PaymentMethod getMethod (String method){
        PaymentMethod paymentMethod = null;

        switch (method){
            case "Credit Card":
                paymentMethod = new CreditCard();
                break;

            case "PayPal":
                paymentMethod = new PayPal();
                break;

            case "Cash":
                paymentMethod = new Cash();
                break;

            default:
                return null;

        }

        return paymentMethod;
    }

}
