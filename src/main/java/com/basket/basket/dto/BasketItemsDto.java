package com.basket.basket.dto;

import com.basket.basket.domain.Basket;
import com.basket.basket.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemsDto {
    private long basketItemId;
    private int quantity;
    private Basket basket;
    private Item item;

    public BasketItemsDto(final long basketItemsId, final int quantity) {
        this.basketItemId = basketItemsId;
        this.quantity = quantity;
    }

    public BasketItemsDto(final int quantity) {
        this.quantity = quantity;
    }
}
