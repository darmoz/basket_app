package com.basket.basket.item;

import com.basket.basket.item.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface ItemDao extends CrudRepository<Item, Long> {

    @Override
    Item save(Item item);

    @Override
    Optional<Item> findById(Long id);

    Item findByItemId(Long id);

    Optional<Item> findByName(String name);

    @Override
    void delete(Item item);
}
