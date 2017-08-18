package com.globant.finalproject.paymentMeethods;

import com.globant.finalproject.model.Cart;
import com.globant.finalproject.service.PaymentMethodService;
import org.springframework.stereotype.Component;

@Component
public class PayPalPaymentMethodImpl implements PaymentMethodService {

    private static final double DISCOUNT = 0.3;
    private String email;
    private String pass;

//    public PayPalPaymentMethodImpl(String email, String pass) {
//        this.email = email;
//        this.pass = pass;
//    }

    @Override
    public void payCart(Cart cart) {
        System.out.println("Payment using Paypal successful. Total amount: " + cart.getTotal()
                + ", amount with discount: " + (cart.getTotal() - calculateDiscount(cart)));
    }

    @Override
    public double calculateDiscount(Cart cart) {
        return cart.getTotal() * DISCOUNT;
    }
}
