package com.globant.finalproject.controllers;

import com.globant.finalproject.model.Item;
import com.globant.finalproject.model.PStock;
import com.globant.finalproject.service.PStockService;
import com.globant.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("stock")
public class PStockRestController {

    private PStockService pStockService;

    @Autowired
    public PStockRestController(PStockService pStockService) {
        this.pStockService = pStockService;
    }

    @PreAuthorize("hasAnyRole()")
    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public List<PStock> getAllStock(){

        List<PStock> listPStocks = pStockService.listPStock();
        return listPStocks;
    }


    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public PStock addStock (@RequestBody PStock pStock){
        if (pStock.getId()==null){
            pStockService.addStock(pStock);
        }else{
            pStockService.updateStock(pStock);
        }
        return null;
    }


    @RequestMapping(value = "{id}", method = PUT)
    @ResponseStatus(OK)
    public PStock updatePStock(@PathVariable("id") Long id, @RequestBody PStock pStock){
        pStock.setId(id);
        pStockService.updateStock(pStock);
        return null;
    }


    @RequestMapping(value = "{id}", method = DELETE)
    @ResponseStatus(OK)
    public PStock removePStock(@PathVariable("id") Long id){
        try {
            pStockService.removeStock(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
