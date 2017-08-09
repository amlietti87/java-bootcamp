package com.globant.finalproject.service;

import com.globant.finalproject.model.Cart;

import java.util.List;

public interface CartService {

    List<Cart> listCarts();

    void addCart (final Cart cart);

    void updateCart (final Cart cart);

    void removeCart (final Long id);

    Cart getCartById (final Long id);
}
