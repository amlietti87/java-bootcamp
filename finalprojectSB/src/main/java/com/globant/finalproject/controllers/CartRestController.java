package com.globant.finalproject.controllers;


import com.globant.finalproject.model.Cart;
import com.globant.finalproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;


    @RequestMapping(method = GET)
    public ResponseEntity<List<Cart>> getAllCarts(){
        return new ResponseEntity<>(cartService.listCarts(), OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Cart> getCartById(@PathVariable Long id){
        return new ResponseEntity<>(cartService.getCartById(id), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity <Cart> addCart(@RequestBody Cart cart){
        return new ResponseEntity<>(cartService.addCart(cart), CREATED);
    }

    @RequestMapping(method = PUT)
    public ResponseEntity<String> updateCart(@RequestBody Cart cart){
        if (cart.getId() == null) {
            return new ResponseEntity<>("There is no cart with id: " + cart.getId(), BAD_REQUEST);
        }
        cartService.updateCart(cart);
        return new ResponseEntity<>("Cart updated: " + cart, OK);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<String> deleteCart(@PathVariable Long id){
        Cart c = cartService.getCartById(id);
        if (c == null) {
            return new ResponseEntity<>("There is no cart with id: " + id, BAD_REQUEST);
        }
        cartService.removeCart(id);
        return new ResponseEntity<>("Cart deleted: " + c, OK);
    }
}
