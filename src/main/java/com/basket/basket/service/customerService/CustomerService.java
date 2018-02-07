package com.basket.basket.service.customerService;

import com.basket.basket.domain.Basket;
import com.basket.basket.dto.BasketDto;
import com.basket.basket.dto.BasketItemsDto;
import com.basket.basket.exceptions.NoOpenBasketException;


public interface CustomerService {

    Basket saveBasket(BasketDto basketDto);
    void addToBasket(BasketItemsDto basketItemsDto) throws NoOpenBasketException;
    Basket closeBasket(BasketDto basketDto);
}
