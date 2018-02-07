package com.basket.basket.service.basketService;

import com.basket.basket.domain.Basket;
import com.basket.basket.dto.BasketDto;
import com.basket.basket.dto.BasketItemsDto;


public interface BasketService {

    Basket saveBasket(BasketDto basketDto);
    void addToBasket(BasketItemsDto basketItemsDto);
    Basket closeBasket(BasketDto basketDto);
}
