package com.globant.finalproject.repositories;

import com.globant.finalproject.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {

}
