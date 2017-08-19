package com.globant.finalproject.paymentMeethods;

import com.globant.finalproject.model.Cart;
import com.globant.finalproject.model.Payment;

public interface PaymentMethodService {

    Payment payCart(String paymentMethod, Long cartId, double amount);
    double calculateDiscount(Cart cart);
}
