package com.basket.basket.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Getter
@NoArgsConstructor
public class ItemDto {
    private long itemId;
    private String name;
    private BigDecimal price;
    private int unit;

}
