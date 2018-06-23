package com.basket.basket.basket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface BasketDao extends CrudRepository<Basket, Long> {

    @Override
    Basket save(Basket basket);

    @Override
    void delete(Basket basket);

    @Override
    Optional<Basket> findById(Long id);

    Basket findBasketByBasketId(Long id);


}
