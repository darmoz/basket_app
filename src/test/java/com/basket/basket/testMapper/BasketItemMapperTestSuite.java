package com.basket.basket.testMapper;

import com.basket.basket.basketItem.BasketItems;
import com.basket.basket.basketItem.BasketItemsDto;
import com.basket.basket.basketItem.BasketItemMapperNoId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasketItemMapperTestSuite {

    private BasketItemMapperNoId basketItemMapperNoId;

    @Before
    public void setup() {
        basketItemMapperNoId = new BasketItemMapperNoId();
    }

    @Test
    public void testBasketItemMapperToDto() {
        //given
        BasketItems basketItems = BasketItems.builder()
                .quantity(20)
                .build();
        //when
        BasketItemsDto basketItemsDto = basketItemMapperNoId.mapToBasketItemsNoIdDto(basketItems);
        //then
        Assert.assertEquals(basketItems.getQuantity(), basketItemsDto.getQuantity());
    }

    @Test
    public void testBasketItemMapperFromDto() {
        //given
        BasketItemsDto basketItemsDto = BasketItemsDto.builder()
                .quantity(20)
                .build();
        //when
        BasketItems basketItems = basketItemMapperNoId.mapToBasketItemsNoId(basketItemsDto);
        //then
        Assert.assertEquals(basketItems.getQuantity(), basketItemsDto.getQuantity());
    }

}
