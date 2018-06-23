package com.basket.basket.basket;

import com.basket.basket.basket.Basket;
import com.basket.basket.basket.BasketDto;

public class BasketMapperNoId {

    public Basket mapToBasket(final BasketDto basketDto) {
        return  Basket.builder()
                .creationDate(basketDto.getCreationDate())
                .build();
    }

    public BasketDto mapToBasketDto(final Basket basket) {
        return  BasketDto.builder()
                .creationDate(basket.getCreationDate())
                .build();
    }
}
