package com.basket.basket.mapper;

import com.basket.basket.domain.BasketItems;
import com.basket.basket.dto.BasketItemsDto;
import org.springframework.stereotype.Component;

@Component
public class BasketItemsMapper {

    public BasketItems mapToBasketItems(final BasketItemsDto basketItemsDto) {
        return new BasketItems(
                basketItemsDto.getBasket(),
                basketItemsDto.getItem(),
                basketItemsDto.getQuantity()
                );
    }

    public BasketItemsDto mapToBasketItemsDto(final BasketItems basketItems) {
        return new BasketItemsDto(
                basketItems.getBasket(),
                basketItems.getItem(),
                basketItems.getQuantity()
        );
    }
}
