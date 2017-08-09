package com.globant.finalproject.service;

import com.globant.finalproject.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> listItem();

    void addItem (final Item item);

    void updateItem (final Item item);

    void removeItem (final Long id);

    Item getItemById (final Long id);
}
