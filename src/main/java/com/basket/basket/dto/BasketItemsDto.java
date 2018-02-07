package com.basket.basket.dto;

import com.basket.basket.domain.Basket;
import com.basket.basket.domain.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasketItemsDto {
    private long basketItemId;
    private int quantity;
    private Basket basket;
    private Item item;

    public BasketItemsDto(final long basketItemsId, final Basket basket, final Item item, final int quantity) {
        this.basketItemId=basketItemsId;
        this.quantity=quantity;
        this.basket=basket;
        this.item=item;
    }

    public BasketItemsDto( final Basket basket, final Item item, final int quantity) {
        this.quantity=quantity;
        this.basket=basket;
        this.item=item;
    }
}
