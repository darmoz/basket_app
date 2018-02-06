package com.basket.basket.dao;

import com.basket.basket.domain.Basket;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BasketDao extends CrudRepository<Basket, Long> {

    @Override
    Basket save(Basket basket);

    @Override
    void delete(Basket basket);

    @Override
    Optional<Basket> findById(Long id);
}
