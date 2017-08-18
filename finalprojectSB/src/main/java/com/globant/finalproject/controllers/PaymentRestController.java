package com.globant.finalproject.controllers;

import com.globant.finalproject.model.Cart;
import com.globant.finalproject.model.PaymentRequest;
import com.globant.finalproject.service.CartService;
import com.globant.finalproject.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
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


    @RequestMapping(value = {"/id/totalamount"}, method = POST)
    public ResponseEntity<String> getAmount(@RequestBody PaymentRequest paymentRequest, @PathVariable Long id) {

        Cart cart = cartService.getCartById(id);
        if (cart == null) {
            return new ResponseEntity<>("The cart is empty",NOT_FOUND);
        }

        double total = cart.getTotal();
        double discount = 0;
        if (paymentRequest.getType().equals(PaymentRequest.PaymentType.CC)) {
           discount = creditCardMethodService.calculateDiscount(cart);
        } else if (paymentRequest.getType().equals(PaymentRequest.PaymentType.PP)) {
            discount = payPalMethodService.calculateDiscount(cart);
        }

        return new ResponseEntity<>("Total: " + total + "\nDiscount: " + (total - discount) + "\nTotal to pay: " + (discount),OK);
    }

}
