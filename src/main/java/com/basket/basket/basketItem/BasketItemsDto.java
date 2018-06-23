package com.basket.basket.basketItem;

import com.basket.basket.basket.Basket;
import com.basket.basket.item.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemsDto {
    private long basketItemId;
    private int quantity;
    private Basket basket;
    private Item item;
}
