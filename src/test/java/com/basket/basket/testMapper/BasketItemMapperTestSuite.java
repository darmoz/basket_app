package com.basket.basket.testMapper;

import com.basket.basket.domain.BasketItems;
import com.basket.basket.dto.BasketItemsDto;
import com.basket.basket.mapper.BasketItemMapperNoId;
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
        BasketItems basketItems = new BasketItems(20);
        //when
        BasketItemsDto basketItemsDto = basketItemMapperNoId.mapToBasketItemsNoIdDto(basketItems);
        //then
        Assert.assertEquals(basketItems.getQuantity(), basketItemsDto.getQuantity());
    }

    @Test
    public void testBasketItemMapperFromDto() {
        //given
        BasketItemsDto basketItemsDto = new BasketItemsDto(20);
        //when
        BasketItems basketItems = basketItemMapperNoId.mapToBasketItemsNoId(basketItemsDto);
        //then
        Assert.assertEquals(basketItems.getQuantity(), basketItemsDto.getQuantity());
    }

}
