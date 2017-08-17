package com.globant.finalproject.controllers;

import com.globant.finalproject.model.Item;
import com.globant.finalproject.service.ItemService;
import com.globant.finalproject.serviceImpl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/item")
public class ItemRestController {


    private ItemService itemService;

    @Autowired
    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }


    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public List <Item> getAllItem(){

        List<Item> listItems = itemService.listItem();
        return listItems;
    }


    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public Item addItem (@RequestBody Item item){
        if (item.getId()==null){
            itemService.addItem(item);
        }else{
            itemService.updateItem(item);
        }
        return null;
    }

    @RequestMapping(value = "{id}", method = PUT)
    @ResponseStatus(OK)
    public Item updateItem(@PathVariable("id") Long id, @RequestBody Item item){
        item.setId(id);
        itemService.updateItem(item);
        return null;
    }


    @RequestMapping(value = "{id}", method = DELETE)
    @ResponseStatus(OK)
    public Item removeItem(@PathVariable("id") Long id){
        try {
            itemService.removeItem(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
