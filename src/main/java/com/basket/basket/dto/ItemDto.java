package com.basket.basket.dto;

import com.basket.basket.domain.Basket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {
    private long itemId;
    private String name;
    private BigDecimal price;
    private Basket basket;
    private int unit;

    public ItemDto(final long itemId, final String name, final BigDecimal price, final int unit) {
        this.itemId=itemId;
        this.name=name;
        this.price=price;
        this.unit=unit;
    }

    public ItemDto(final String name, final BigDecimal price, final int unit) {
        this.name=name;
        this.price=price;
        this.unit=unit;
    }

}
