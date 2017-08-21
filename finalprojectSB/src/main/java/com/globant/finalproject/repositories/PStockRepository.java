package com.globant.finalproject.repositories;

import com.globant.finalproject.model.PStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PStockRepository extends JpaRepository<PStock, Long> {

    PStock findPStockByProductId(Long productId);
}
