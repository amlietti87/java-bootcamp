package com.globant.finalproject.paymentMeethods;

import com.globant.finalproject.model.Cart;

public interface IPaymentMethod {

    PaymentRequest getType();

    void payCart(Cart cart);

    double calculateDiscount(Cart cart);

}
