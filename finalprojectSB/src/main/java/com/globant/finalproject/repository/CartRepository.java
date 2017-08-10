package com.globant.finalproject.repository;

import com.globant.finalproject.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Long> {

}
