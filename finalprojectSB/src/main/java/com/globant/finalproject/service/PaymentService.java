package com.globant.finalproject.service;

import com.globant.finalproject.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> listPayments();

    void addPayment (final Payment payment);

    void updatePayment (final Payment payment);

    void removePayment (final Long id);

    Payment getById (final Long id);
}
