package com.basket.basket.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasketItemsDto {
    private long Id;
    private int quantity;

    public BasketItemsDto(final int quantity) {
        this.quantity=quantity;
    }
}
