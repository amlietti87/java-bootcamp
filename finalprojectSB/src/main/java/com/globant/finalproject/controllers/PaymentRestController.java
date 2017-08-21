package com.globant.finalproject.controllers;

import com.globant.finalproject.model.Cart;
import com.globant.finalproject.model.Payment;
import com.globant.finalproject.paymentMeethods.PaymentMethodService;
import com.globant.finalproject.paymentMeethods.PaymentRequest;
import com.globant.finalproject.service.CartService;
import com.globant.finalproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {

    @Autowired
    @Qualifier("creditCardPaymentMethodImpl")
    private PaymentMethodService creditCardMethodService;

    @Autowired
    @Qualifier("payPalPaymentMethodImpl")
    private PaymentMethodService payPalMethodService;


    private PaymentService paymentService;

    @Autowired
    private CartService cartService;

    @Autowired
    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> listPayments = paymentService.listPayments();
        return new ResponseEntity<>(listPayments, OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            throw new MyException("The payment with id " + payment.getId() + "doesn't exists");
        }
        return new ResponseEntity<>(payment, OK);
    }

    @RequestMapping(value = "/cart/{idCart}", method = GET)
    public ResponseEntity<Payment> getPaymentByCartId(@PathVariable Long idCart) {
        Cart cart = cartService.getCartById(idCart);
        if (cart == null) {
            throw new MyException("The payment with id " + cart.getId() + "doesn't exists");
        }
        if (!cart.isCartPaid()) {
            throw new MyException("The cart isn't paid yet");
        }
        return new ResponseEntity<>(paymentService.getPaymentByCartId(idCart), OK);
    }


    @RequestMapping(value = {"/totalamount/{id}"}, method = POST)
    public ResponseEntity<String> getAmount(@PathVariable Long id, @RequestBody PaymentRequest paymentRequest) {

        Cart cart = cartService.getCartById(id);
        if (cart == null) {

            return new ResponseEntity<>("The cart is empty",NO_CONTENT);
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
                OK);
    }


    @RequestMapping(value = {"/paid/{id}"}, method = POST)
    public ResponseEntity<String> paid(@PathVariable Long id, @RequestBody PaymentRequest paymentRequest) {
        Cart cart = cartService.getCartById(id);
        String paymentType = null;
        Payment payment = null;
        if (cart == null) {
            throw new MyException("The cart is empty");
        } else if (cart.isCartPaid()) {
            throw new MyException("The cart has already been paid");
        } else if (paymentRequest.getType().equals(PaymentRequest.PaymentType.CC)) {
             paymentType = "CreditCard";
             payment = creditCardMethodService.payCart(paymentType, id,0);
        } else if (paymentRequest.getType().equals(PaymentRequest.PaymentType.PP)) {
             paymentType = "PayPal";
             payment = payPalMethodService.payCart(paymentType, id,0);
        }
        return new ResponseEntity<>("Your payment was satisfactoty, your payment method: " + paymentType + " total paid: " + payment.getTotalAmount(),
                HttpStatus.CREATED);
    }
}
