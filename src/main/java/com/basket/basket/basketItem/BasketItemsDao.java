package com.basket.basket.basketItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface BasketItemsDao extends CrudRepository<BasketItems, Long> {

    @Override
    BasketItems save(BasketItems basketItems);

    @Override
    void delete(BasketItems basketItems);

    @Override
    Optional<BasketItems> findById(Long id);

    long count();

}
