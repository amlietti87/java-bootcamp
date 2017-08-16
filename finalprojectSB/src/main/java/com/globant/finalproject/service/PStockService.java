package com.globant.finalproject.service;

import com.globant.finalproject.model.PStock;

import java.util.List;

public interface PStockService {
    List<PStock> listPStock();

    void addStock(final PStock pStock);

    void updateStock(final PStock pStock);

    void removeStock (final Long id);

    PStock getById(final Long id);
}
