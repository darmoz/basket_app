package com.basket.basket.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {
    private long itemId;
    private String name;
    private double price;

    public ItemDto(final String name, final double price) {
        this.name=name;
        this.price=price;
    }

}
