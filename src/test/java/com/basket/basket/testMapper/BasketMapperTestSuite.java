package com.basket.basket.testMapper;

import com.basket.basket.basket.Basket;
import com.basket.basket.basket.BasketDto;
import com.basket.basket.basket.BasketMapperNoId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasketMapperTestSuite {
    private BasketMapperNoId basketMapperNoId;

    @Before
    public void setup() {
        basketMapperNoId = new BasketMapperNoId();
    }

    @Test
    public void testBasketMapperToDto() {
        //given
        Basket basket = Basket.builder()
                .creationDate(new Date())
                .build();
        //when
        BasketDto basketDto = basketMapperNoId.mapToBasketDto(basket);
        //then
        Assert.assertEquals(basket.getCreationDate(), basketDto.getCreationDate());
    }

    @Test
    public void testBasketMapperFromDto() {
        //given
        BasketDto basketDto = BasketDto.builder()
                .creationDate(new Date())
                .build();
        //when
        Basket basket = basketMapperNoId.mapToBasket(basketDto);
        //then
        Assert.assertEquals(basket.getCreationDate(), basketDto.getCreationDate());
    }
}
