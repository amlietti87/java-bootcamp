package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.Shop;
import com.globant.finalproject.repositories.ShopRepository;
import com.globant.finalproject.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public List<Shop> listShop() {
        return shopRepository.findAll();
    }

    @Override
    public void addShop(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public void updateShop(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public void removeShop(Long id) {
        shopRepository.delete(id);
    }

    @Override
    public Shop getShopById(Long id) {
        return shopRepository.findOne(id);
    }
}
