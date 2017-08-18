package com.globant.finalproject.paymentMeethods;

import com.globant.finalproject.model.Cart;
import com.globant.finalproject.service.PaymentMethodService;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class CreditCardPaymentMethodImpl implements PaymentMethodService {


    // Fields
    private static final double DISCOUNT = 0.1;
    private String name;
    private String cardNumber;
    private String verificationNumber;
    private String expirationDate;

//    public CreditCardPaymentMethodImpl(String name, String cardNumber, String verificationNumber, String expirationDate) {
//        this.name = name;
//        this.cardNumber = cardNumber;
//        this.verificationNumber = verificationNumber;
//        this.expirationDate = expirationDate;
//    }


    @Override
    public void payCart(Cart cart) {
        System.out.println("Payment using Credit Card successful. Total amount: " + cart.getTotal()
                + ", amount with discount: " + (cart.getTotal() - calculateDiscount(cart)));
    }

    @Override
    public double calculateDiscount(Cart cart) {
        return cart.getTotal() * DISCOUNT;
    }
}
