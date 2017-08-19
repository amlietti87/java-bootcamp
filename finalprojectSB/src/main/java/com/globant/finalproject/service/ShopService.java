package com.globant.finalproject.service;

import com.globant.finalproject.model.Shop;

import java.util.List;

public interface ShopService {

    List<Shop> listShop();

    void addShop (final Shop shop);

    void updateShop (final Shop shop);

    void removeShop (final Long id);

    Shop getShopById (final Long id);
}
