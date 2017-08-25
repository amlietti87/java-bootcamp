package com.globant.finalproject.repositories;

import com.globant.finalproject.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("Select p from Payment p where p.cart.id=?1")
    Payment findPaymentByCartId(Long idCart);
}
