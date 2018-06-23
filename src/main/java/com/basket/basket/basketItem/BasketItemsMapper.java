package com.basket.basket.basketItem;

import org.springframework.stereotype.Component;

@Component
public class BasketItemsMapper {

    public BasketItems mapToBasketItems(final BasketItemsDto basketItemsDto) {
        return BasketItems.builder()
                .basketItemsId(basketItemsDto.getBasketItemId())
                .quantity(basketItemsDto.getQuantity())
                .build();
    }

    public BasketItemsDto mapToBasketItemsDto(final BasketItems basketItems) {
        return BasketItemsDto.builder()
                .basketItemId(basketItems.getBasketItemId())
                .quantity(basketItems.getQuantity())
                .build();
    }

    public BasketItems mapToBasketItemsNoId(final BasketItemsDto basketItemsDto) {
        return BasketItems.builder()
                .basketItemsId(basketItemsDto.getBasketItemId())
                .quantity(basketItemsDto.getQuantity())
                .build();
    }

    public BasketItemsDto mapToBasketItemsDtoNoId(final BasketItems basketItems) {
        return BasketItemsDto.builder()
                .basketItemId(basketItems.getBasketItemId())
                .quantity(basketItems.getQuantity())
                .build();
    }
}
