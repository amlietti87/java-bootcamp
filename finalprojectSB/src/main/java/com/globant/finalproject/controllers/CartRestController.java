package com.globant.finalproject.controllers;


import com.globant.finalproject.model.Cart;
import com.globant.finalproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(name = "/cart")
public class CartRestController {

    private CartService cartService;

    @Autowired
    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public List<Cart> getAllCarts(){

        List<Cart> listCarts = cartService.listCarts();
        return listCarts;
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public Cart addCart (@RequestBody Cart cart){
        if (cart.getId()==null){
           cartService.addCart(cart);
        }else{
            cartService.updateCart(cart);
        }
        return null;
    }


    @RequestMapping(value = "{id}", method = PUT)
    @ResponseStatus(OK)
    public Cart updateCart(@PathVariable("id") Long id, @RequestBody Cart cart){
        cart.setId(id);
        cartService.updateCart(cart);
        return null;
    }


    @RequestMapping(value = "{id}", method = DELETE)
    @ResponseStatus(OK)
    public String removeCart(@PathVariable("id") Long id){
        try {
            cartService.removeCart(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/category/list";
    }
}
