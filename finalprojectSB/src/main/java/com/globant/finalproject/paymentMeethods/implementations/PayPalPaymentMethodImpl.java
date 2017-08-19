package com.globant.finalproject.paymentMeethods.implementations;

import com.globant.finalproject.model.Cart;
import com.globant.finalproject.model.Payment;
import com.globant.finalproject.paymentMeethods.PaymentMethodService;
import com.globant.finalproject.repositories.CartRepository;
import com.globant.finalproject.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class PayPalPaymentMethodImpl implements PaymentMethodService {


    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CartRepository cartRepository;

    private String email;
    private String pass;

//    public PayPalPaymentMethodImpl(String email, String pass) {
//        this.email = email;
//        this.pass = pass;
//    }

//    @Override
//    public void payCart(Cart cart) {
//        System.out.println("Payment using Paypal successful. Total amount: " + cart.getTotal()
//                + ", amount with discount: " + (cart.getTotal() - calculateDiscount(cart)));
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
        return cart.getCheapestitem().getProduct().getProductPrice();
    }
}
