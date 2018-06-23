package com.basket.basket.basketItem;

import com.basket.basket.basketItem.BasketItems;
import com.basket.basket.basketItem.BasketItemsDto;
import org.springframework.stereotype.Component;

@Component
public class BasketItemMapperNoId {

    public BasketItems mapToBasketItemsNoId(final BasketItemsDto basketItemsDto) {
        return new BasketItems(
                /*basketItemsDto.getBasket(),
                basketItemsDto.getItem(),*/
                basketItemsDto.getQuantity()
        );
    }

    public BasketItemsDto mapToBasketItemsNoIdDto(final BasketItems basketItems) {
        return new BasketItemsDto(
                /*basketItems.getBasket(),
                basketItems.getItem(),*/
                basketItems.getQuantity()
        );
    }
}
