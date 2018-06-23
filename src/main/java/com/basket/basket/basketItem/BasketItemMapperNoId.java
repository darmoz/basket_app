package com.basket.basket.basketItem;

import org.springframework.stereotype.Component;

@Component
public class BasketItemMapperNoId {

    public BasketItems mapToBasketItemsNoId(final BasketItemsDto basketItemsDto) {
        return BasketItems.builder()
                .quantity(basketItemsDto.getQuantity())
                .build();
    }

    public BasketItemsDto mapToBasketItemsNoIdDto(final BasketItems basketItems) {
        return BasketItemsDto.builder()
                .quantity(basketItems.getQuantity())
                .build();
    }
}
