package com.globant.finalproject.controllers;

import com.globant.finalproject.model.PStock;
import com.globant.finalproject.model.Product;
import com.globant.finalproject.model.Shop;
import com.globant.finalproject.service.CartService;
import com.globant.finalproject.service.PStockService;
import com.globant.finalproject.service.ProductService;
import com.globant.finalproject.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/shop")
public class ShopRestController {


    private ShopService shopService;

    @Autowired
    public ShopRestController(ShopService shopService) {
        this.shopService = shopService;
    }


    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public List <Shop> getAllShops(){

        List<Shop> listShops = shopService.listShop();
        return listShops;
    }


    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public Shop addShop (@RequestBody Shop shop) {
        int stock = shop.getProduct().getStock().getStockQuantity();
        int items = shop.getShopQuantity();
        //System.out.println(stock);
        System.out.println(items);
        //if ( stock > items ) {
            if (shop.getId() == null) {
                shopService.addShop(shop);
            } else if(shop.getId() != null) {
                shopService.updateShop(shop);
            }//else{

              //  throw new MyException("We do not have the availability of requested products");
            //}

        //}
       return null;
    }

    @RequestMapping(value = "{id}", method = PUT)
    @ResponseStatus(OK)
    public Shop updateShop(@PathVariable("id") Long id, @RequestBody Shop shop){
        shop.setId(id);
        shopService.updateShop(shop);
        return null;
    }


    @RequestMapping(value = "{id}", method = DELETE)
    @ResponseStatus(OK)
    public Shop removeShop(@PathVariable("id") Long id){
        try {
            shopService.removeShop(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
