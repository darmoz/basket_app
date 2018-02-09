package com.basket.basket.service.customerService;

import com.basket.basket.domain.Basket;
import com.basket.basket.dto.BasketDto;
import com.basket.basket.exceptions.NoOpenBasketException;


public interface CustomerService {

    Basket saveBasket(BasketDto basketDto);

    Basket addToBasket(String itemName, int quantity) throws NoOpenBasketException;

    Basket closeBasket() throws NoOpenBasketException;
}
