package com.basket.basket.dao;

import com.basket.basket.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemDao extends CrudRepository<Item, Long> {

    @Override
    Item save(Item item);

    @Override
    Optional<Item> findById(Long id);

    @Override
    void delete(Item item);
}
