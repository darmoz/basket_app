package com.basket.basket.basket;


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
