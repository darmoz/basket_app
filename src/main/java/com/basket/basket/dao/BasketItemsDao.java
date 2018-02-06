package com.basket.basket.dao;

import com.basket.basket.domain.BasketItems;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BasketItemsDao extends CrudRepository<BasketItems, Long> {

    @Override
    BasketItems save(BasketItems basketItems);

    @Override
    void delete(BasketItems basketItems);

    @Override
    Optional<BasketItems> findById(Long id);
}
