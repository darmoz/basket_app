package com.basket.basket.item;

import com.basket.basket.item.Item;
import com.basket.basket.item.ItemDto;

public class ItemMapperNoId {

    public Item mapItem(final ItemDto itemDto) {
        return Item.builder()
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .unit(itemDto.getUnit())
                .build();
    }

    public ItemDto mapItemDto(final Item item) {
        return ItemDto.builder()
                .name(item.getName())
                .price(item.getPrice())
                .unit(item.getUnit())
                .build();
    }
}
