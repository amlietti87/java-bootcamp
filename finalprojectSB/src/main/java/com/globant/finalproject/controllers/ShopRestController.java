package com.globant.finalproject.controllers;

import com.globant.finalproject.model.PStock;
import com.globant.finalproject.model.Product;
import com.globant.finalproject.model.Shop;
import com.globant.finalproject.repositories.PStockRepository;
import com.globant.finalproject.service.CartService;
import com.globant.finalproject.service.PStockService;
import com.globant.finalproject.service.ProductService;
import com.globant.finalproject.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/shop")
public class ShopRestController {


    @Autowired
    private PStockService pStockService;


    private ShopService shopService;

    @Autowired
    public ShopRestController(ShopService shopService) {
        this.shopService = shopService;
    }


    @RequestMapping(method = GET)
    public ResponseEntity<List <Shop>> getAllShops(){

        List<Shop> listShops = shopService.listShop();
        return new ResponseEntity<>(listShops, OK) ;
    }


    @RequestMapping(method = POST)
    public ResponseEntity<Shop> addShop (@RequestBody Shop shop) {
        Long productId = shop.getProduct().getId();
        PStock stock = pStockService.findPStockByProductId(productId);
        int items = shop.getShopQuantity();
        if ((stock.getStockQuantity() - items) >= 0) {
            if (shop.getId() == null) {
                shopService.addShop(shop);
                return new ResponseEntity<>(shop, CREATED);
            } else if(shop.getId() != null) {
                shopService.updateShop(shop);
                return new ResponseEntity<>(shop, OK);
            }else{

                throw new MyException("We do not have the availability of requested products");
            }

        }
       return new ResponseEntity<>(shop, NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<String> updateShop(@PathVariable("id") Long id, @RequestBody Shop shop){
        Shop shopping = shopService.getShopById(id);
        if (shopping == null){
            return new ResponseEntity<>("The shop with id "+ shop.getId()+ " doesn't exists", NOT_FOUND);
        }
        shopService.updateShop(shop);
        return new ResponseEntity<>("Shop with id "+ shop.getId()+ " was updated", OK);
    }


    @RequestMapping(value = "/{id}", method = DELETE)
    @ResponseStatus(OK)
    public ResponseEntity<String> removeShop(@PathVariable("id") Long id){
        try {
           shopService.removeShop(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Shop deleted OK", OK);
    }
}
