package com.basket.basket.service.customerService;

import com.basket.basket.basket.Basket;
import com.basket.basket.basket.BasketDto;
import com.basket.basket.exceptions.NoOpenBasketException;


public interface CustomerService {

    Basket saveBasket(BasketDto basketDto);

    Basket addToBasket(String itemName, int quantity) throws NoOpenBasketException;

    Basket closeBasket() throws NoOpenBasketException;
}
