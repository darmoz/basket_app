package com.basket.basket.item;

import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item mapItem(final ItemDto itemDto) {
        return Item.builder()
                .itemId(itemDto.getItemId())
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .unit(itemDto.getUnit())
                .build();
    }

    public ItemDto mapItemDto(final Item item) {
        return ItemDto.builder()
                .itemId(item.getItemId())
                .name(item.getName())
                .price(item.getPrice())
                .unit(item.getUnit())
                .build();
    }


}
