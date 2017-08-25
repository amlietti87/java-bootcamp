package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.Payment;
import com.globant.finalproject.repositories.PaymentRepository;
import com.globant.finalproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public List<Payment> listPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findOne(id);
    }

    @Override
    public Payment getPaymentByCartId(Long idCart) {
        return paymentRepository.findPaymentByCartId(idCart);
    }
}
