package com.globant.finalproject.serviceImpl;

import com.globant.finalproject.model.Item;
import com.globant.finalproject.repository.ItemRepository;
import com.globant.finalproject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> listItem() {
        return itemRepository.findAll();
    }

    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void removeItem(Long id) {
        itemRepository.delete(id);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.getOne(id);
    }
}
