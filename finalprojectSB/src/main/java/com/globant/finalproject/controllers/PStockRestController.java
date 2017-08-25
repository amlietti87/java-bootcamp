package com.globant.finalproject.controllers;

import com.globant.finalproject.model.PStock;
import com.globant.finalproject.service.PStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
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

    @RequestMapping(method = GET)
    public ResponseEntity<List<PStock>> getAllStock(){

        List<PStock> listPStocks = pStockService.listPStock();
        return new ResponseEntity<>(listPStocks, OK);
    }


    @RequestMapping(method = POST)
    public ResponseEntity<PStock> addStock (@RequestBody PStock pStock){
        if (pStock.getId()==null){
            pStockService.addStock(pStock);
            return new ResponseEntity<>(pStock, CREATED);
        }else{
            pStockService.updateStock(pStock);
            return new ResponseEntity<>(pStock, OK);
        }
    }


    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<String> updatePStock(@PathVariable("id") Long id, @RequestBody PStock pStock){
        PStock stock = pStockService.getPStockById(id);
        if (stock == null){
            return new ResponseEntity<>("The stock with id "+ pStock.getId()+ " doesn't exists", NOT_FOUND);
        }
        pStockService.updateStock(pStock);
        return new ResponseEntity<>("Stock with id "+ pStock.getId()+ " was updated", OK);
    }


    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<String> removePStock(@PathVariable("id") Long id){
        try {
            pStockService.removeStock(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Stock deleted OK", OK);
    }
}
