package com.globant.finalproject.repositories;

import com.globant.finalproject.model.PStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PStockRepository extends JpaRepository<PStock, Long> {
}
