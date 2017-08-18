package com.globant.finalproject.service;

import com.globant.finalproject.model.Cart;

public interface PaymentMethodService {

    void payCart(Cart cart);
    double calculateDiscount(Cart cart);
}
