package com.basket.basket.mapper;

import com.basket.basket.domain.Item;
import com.basket.basket.dto.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item mapItem(final ItemDto itemDto) {
        return new Item(
            itemDto.getName(),
            itemDto.getPrice(),
            itemDto.getUnit()
        );
    }
    public ItemDto mapItemDto(final Item item) {
        return new ItemDto(
                item.getName(),
                item.getPrice(),
                item.getUnit()
        );
    }


}
