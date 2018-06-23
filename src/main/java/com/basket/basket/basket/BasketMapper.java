package com.basket.basket.basket;

import org.springframework.stereotype.Component;

@Component
public class BasketMapper {

    public Basket mapToBasket(final BasketDto basketDto) {

        return Basket.builder()
                .basketId(basketDto.getBasketId())
                .subtotal(basketDto.getSubtotal())
                .creationDate(basketDto.getCreationDate())
                .build();
    }

    public BasketDto mapToBasketDto(final Basket basket) {
        return BasketDto.builder()
                .basketId(basket.getBasketId())
                .subtotal(basket.getSubtotal())
                .creationDate(basket.getCreationDate())
                .build();
    }
}
