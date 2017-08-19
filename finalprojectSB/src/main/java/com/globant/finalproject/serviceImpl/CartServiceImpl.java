package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.Cart;
import com.globant.finalproject.repositories.CartRepository;
import com.globant.finalproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> listCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void removeCart(Long id) {
        cartRepository.delete(id);
    }

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.getOne(id);
    }
}
