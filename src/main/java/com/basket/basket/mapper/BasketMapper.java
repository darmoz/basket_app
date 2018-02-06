package com.basket.basket.mapper;

import com.basket.basket.domain.Basket;
import com.basket.basket.dto.BasketDto;
import org.springframework.stereotype.Component;

@Component
public class BasketMapper {

    public Basket mapToBasket(final BasketDto basketDto) {
        return new Basket();
    }

    public BasketDto mapToBasketDto(final Basket basket) {
        return new BasketDto();
    }
}
