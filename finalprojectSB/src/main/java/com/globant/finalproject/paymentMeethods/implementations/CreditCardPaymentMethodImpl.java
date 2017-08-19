package com.globant.finalproject.paymentMeethods.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globant.finalproject.model.Cart;
import com.globant.finalproject.model.Payment;
import com.globant.finalproject.repositories.CartRepository;
import com.globant.finalproject.repositories.PaymentRepository;
import com.globant.finalproject.paymentMeethods.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class CreditCardPaymentMethodImpl implements PaymentMethodService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CartRepository cartRepository;

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
    public Payment payCart(String paymentMethod, Long cartId, double amount) {

        Cart cart = cartRepository.findOne(cartId);
        double total = cart.getTotal();
        double discount = 0;
        discount = calculateDiscount(cart);
        amount = total - discount;

        DecimalFormat df = new DecimalFormat("00.00");
        // Execute payment
        cart.setPaid(1);
        Payment payment = new Payment(cart,paymentMethod,amount);
        paymentRepository.save(payment);
        cartRepository.save(cart);
        return payment;
    }

    @Override
    public double calculateDiscount(Cart cart) {
        return cart.getTotal() * DISCOUNT;
    }
}
