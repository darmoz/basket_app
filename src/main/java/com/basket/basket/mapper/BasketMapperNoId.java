package com.basket.basket.mapper;

import com.basket.basket.domain.Basket;
import com.basket.basket.dto.BasketDto;

public class BasketMapperNoId {

    public Basket mapToBasket(final BasketDto basketDto) {
        return new Basket(
                basketDto.getCreationDate()
        );
    }

    public BasketDto mapToBasketDto(final Basket basket) {
        return new BasketDto(
                basket.getCreationDate()
        );
    }
}
