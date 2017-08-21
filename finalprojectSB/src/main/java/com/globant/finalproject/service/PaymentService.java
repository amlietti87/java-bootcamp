package com.globant.finalproject.service;

import com.globant.finalproject.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> listPayments();

    Payment getPaymentById(Long id);

    Payment getPaymentByCartId(Long idCart);

}
