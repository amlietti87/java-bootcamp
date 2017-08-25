package com.globant.finalproject.repositories;

import com.globant.finalproject.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findByCartId(Long cartId);
}
