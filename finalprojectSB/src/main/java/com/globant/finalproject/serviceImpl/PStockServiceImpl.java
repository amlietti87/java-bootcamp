package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.PStock;
import com.globant.finalproject.repositories.PStockRepository;
import com.globant.finalproject.service.PStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PStockServiceImpl implements PStockService {

    @Autowired
    private PStockRepository pStockRepository;

    @Override
    public List<PStock> listPStock() {
        return pStockRepository.findAll();
    }

    @Override
    public void addStock(PStock pStock) {
        pStockRepository.save(pStock);
    }

    @Override
    public void updateStock(PStock pStock) {
        pStockRepository.save(pStock);
    }

    @Override
    public void removeStock(Long id) {
        pStockRepository.delete(id);
    }

    @Override
    public PStock getById(Long id) {
        return pStockRepository.getOne(id);
    }
}
