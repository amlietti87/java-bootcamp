package com.globant.finalproject.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globant.finalproject.model.Cart;
import com.globant.finalproject.model.Payment;
import com.globant.finalproject.paymentMeethods.PaymentRequest;
import com.globant.finalproject.service.CartService;
import com.globant.finalproject.paymentMeethods.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(name = "/paid")
public class PaymentRestController {

    @Autowired
    @Qualifier("creditCardPaymentMethodImpl")
    private PaymentMethodService creditCardMethodService;

    @Autowired
    @Qualifier("payPalPaymentMethodImpl")
    private PaymentMethodService payPalMethodService;

    @Autowired
    private CartService cartService;


    @RequestMapping(value = {"/totalamount/{id}"}, method = POST)
    public ResponseEntity<String> getAmount(@PathVariable Long id, @RequestBody PaymentRequest paymentRequest) {

        Cart cart = cartService.getCartById(id);
        if (cart == null) {

            return new ResponseEntity<>("The cart is empty",NOT_FOUND);
        }

        double total = cart.getTotal();
        double discount = 0;
        DecimalFormat df = new DecimalFormat("00.00");

        if (paymentRequest.getType().equals(PaymentRequest.PaymentType.CC)) {
           discount = creditCardMethodService.calculateDiscount(cart);
        } else if (paymentRequest.getType().equals(PaymentRequest.PaymentType.PP)) {
            discount = payPalMethodService.calculateDiscount(cart);
        }

        return new ResponseEntity<>(
                "SubTotal: " + df.format(total) + "\nDiscount: " + df.format(discount) + "\nTotal to pay: " + df.format(total - discount),
                HttpStatus.OK);
    }


    @RequestMapping(value = {"/paid/{id}"}, method = POST)
    public ResponseEntity<String> paid(@PathVariable Long id, @RequestBody PaymentRequest paymentRequest) {
        Cart cart = cartService.getCartById(id);
        if (cart == null) {
            throw new MyException("The cart is empty");
        } else if (cart.getPaid() == 1) {
            throw new MyException("The cart has already been paid");
        } else if (paymentRequest.getType().equals(PaymentRequest.PaymentType.CC)) {
            String paymentType = "CreditCard";
            Payment payment = creditCardMethodService.payCart(paymentType, id,0);
            return new ResponseEntity<>("Paid Complete", HttpStatus.OK);
        } else if (paymentRequest.getType().equals(PaymentRequest.PaymentType.PP)) {
            String paymentType = "PayPal";
            Payment payment = payPalMethodService.payCart(paymentType, id,0);
            return new ResponseEntity<>("Paid Complete", HttpStatus.OK);
        }
            return null;
    }
}
