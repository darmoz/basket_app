package com.basket.basket.testMapper;

import com.basket.basket.item.Item;
import com.basket.basket.item.ItemDto;
import com.basket.basket.item.ItemMapperNoId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTestSutie {
    private ItemMapperNoId itemMapperNoId;

    @Before
    public void setup() {
        itemMapperNoId = new ItemMapperNoId();
    }

    @Test
    public void testItemMapperToDto() {
        //given
        Item item = Item.builder()
                .name("test")
                .price(BigDecimal.valueOf(5))
                .unit(5)
                .build();

        //when
        ItemDto itemDto = itemMapperNoId.mapItemDto(item);
        //then
        Assert.assertEquals(item.getName(), itemDto.getName());
        Assert.assertEquals(item.getPrice().doubleValue(), itemDto.getPrice().doubleValue(), 0.0);
        Assert.assertEquals(item.getUnit(), itemDto.getUnit());
    }

    @Test
    public void testItemMapperFromDto() {
        //given
        ItemDto itemDto = ItemDto.builder()
                .name("test")
                .price(BigDecimal.valueOf(5))
                .unit(5)
                .build();
        //when
        Item item = itemMapperNoId.mapItem(itemDto);
        //then
        Assert.assertEquals(item.getName(), itemDto.getName());
        Assert.assertEquals(item.getPrice().doubleValue(), itemDto.getPrice().doubleValue(), 0.0);
        Assert.assertEquals(item.getUnit(), itemDto.getUnit());
    }
}
