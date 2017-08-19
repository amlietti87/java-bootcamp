package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.Payment;
import com.globant.finalproject.repositories.PaymentRepository;
import com.globant.finalproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> listPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void removePayment(Long id) {
        paymentRepository.delete(id);
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepository.getOne(id);
    }
}
