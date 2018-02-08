package com.basket.basket.testServices;

import com.basket.basket.domain.Basket;
import com.basket.basket.domain.BasketItems;
import com.basket.basket.domain.Item;
import com.basket.basket.service.discount.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountServiceTestSuite {

    @Test
    public void testDiscountButterDecorator() {
        //given
        Item item = new Item(3L, "butter", BigDecimal.valueOf(5.0), 200);
        Basket basket = new Basket(new Date());
        BasketItems basketItems1 = new BasketItems(1L, 50, basket, item);
        basket.getBasketItemsList().add(basketItems1);
        //when
        CustomerCost customerCost = new StandardCost(basket);
        customerCost = new ButterDiscountDecorator(customerCost, basketItems1);
        BigDecimal result = customerCost.cost();
        //then
        Assert.assertEquals(BigDecimal.valueOf(247.5).doubleValue(),result.doubleValue(), 0.0);
        Assert.assertEquals("Total shopping cost - [1% of butter price]", customerCost.description());
    }

    @Test
    public void testNoDiscountButterDecorator() {
        //given
        Item item = new Item(3L, "butter", BigDecimal.valueOf(5.0), 200);
        Basket basket = new Basket(new Date());
        BasketItems basketItems1 = new BasketItems(1L, 5, basket, item);
        basket.getBasketItemsList().add(basketItems1);
        //when
        CustomerCost customerCost = new StandardCost(basket);
        customerCost = new ButterDiscountDecorator(customerCost, basketItems1);
        BigDecimal result = customerCost.cost();
        //then
        Assert.assertEquals(BigDecimal.valueOf(25).doubleValue(),result.doubleValue(), 0.0);
        Assert.assertEquals("Total shopping cost", customerCost.description());
    }

    @Test
    public void testDiscountMilkDecorator() {
        //given
        Item item = new Item(3L, "milk", BigDecimal.valueOf(5.0), 200);
        Basket basket = new Basket(new Date());
        BasketItems basketItems1 = new BasketItems(1L, 100, basket, item);
        basket.getBasketItemsList().add(basketItems1);
        //when
        CustomerCost customerCost = new StandardCost(basket);
        customerCost = new MilkDiscountDecorator(customerCost, basketItems1);
        BigDecimal result = customerCost.cost();
        //then
        Assert.assertEquals(BigDecimal.valueOf(450).doubleValue(),result.doubleValue(), 0.0);
        Assert.assertEquals("Total shopping cost - [10% of milk price]", customerCost.description());
    }

    @Test
    public void testNoDiscountMilkDecorator() {
        //given
        Item item = new Item(3L, "milk", BigDecimal.valueOf(5.0), 200);
        Basket basket = new Basket(new Date());
        BasketItems basketItems1 = new BasketItems(1L, 5, basket, item);
        basket.getBasketItemsList().add(basketItems1);
        //when
        CustomerCost customerCost = new StandardCost(basket);
        customerCost = new MilkDiscountDecorator(customerCost, basketItems1);
        BigDecimal result = customerCost.cost();
        //then
        Assert.assertEquals(BigDecimal.valueOf(25).doubleValue(),result.doubleValue(), 0.0);
        Assert.assertEquals("Total shopping cost", customerCost.description());
    }

    @Test
    public void testDiscountBreadDecorator() {
        //given
        Item item = new Item(3L, "bread", BigDecimal.valueOf(5.0), 200);
        Basket basket = new Basket(new Date());
        BasketItems basketItems1 = new BasketItems(1L, 100, basket, item);
        basket.getBasketItemsList().add(basketItems1);
        //when
        CustomerCost customerCost = new StandardCost(basket);
        customerCost = new BreadDiscountDecorator(customerCost, basketItems1);
        BigDecimal result = customerCost.cost();
        //then
        Assert.assertEquals(BigDecimal.valueOf(475).doubleValue(),result.doubleValue(), 0.0);
        Assert.assertEquals("Total shopping cost - [5% of bread price]", customerCost.description());
    }

    @Test
    public void testNoDiscountBreadDecorator() {
        //given
        Item item = new Item(3L, "bread", BigDecimal.valueOf(5.0), 200);
        Basket basket = new Basket(new Date());
        BasketItems basketItems1 = new BasketItems(1L, 5, basket, item);
        basket.getBasketItemsList().add(basketItems1);
        //when
        CustomerCost customerCost = new StandardCost(basket);
        customerCost = new BreadDiscountDecorator(customerCost, basketItems1);
        BigDecimal result = customerCost.cost();
        //then
        Assert.assertEquals(BigDecimal.valueOf(25).doubleValue(),result.doubleValue(), 0.0);
        Assert.assertEquals("Total shopping cost", customerCost.description());
    }

    @Test
    public void testDiscountHamDecorator() {
        //given
        Item item = new Item(3L, "ham", BigDecimal.valueOf(5.0), 200);
        Basket basket = new Basket(new Date());
        BasketItems basketItems1 = new BasketItems(1L, 100, basket, item);
        basket.getBasketItemsList().add(basketItems1);
        //when
        CustomerCost customerCost = new StandardCost(basket);
        customerCost = new HamDiscountDecorator(customerCost, basketItems1);
        BigDecimal result = customerCost.cost();
        //then
        Assert.assertEquals(BigDecimal.valueOf(490).doubleValue(),result.doubleValue(), 0.0);
        Assert.assertEquals("Total shopping cost - [2% of ham price]", customerCost.description());
    }

    @Test
    public void testNoDiscountHamDecorator() {
        //given
        Item item = new Item(3L, "ham", BigDecimal.valueOf(5.0), 200);
        Basket basket = new Basket(new Date());
        BasketItems basketItems1 = new BasketItems(1L, 5, basket, item);
        basket.getBasketItemsList().add(basketItems1);
        //when
        CustomerCost customerCost = new StandardCost(basket);
        customerCost = new HamDiscountDecorator(customerCost, basketItems1);
        BigDecimal result = customerCost.cost();
        //then
        Assert.assertEquals(BigDecimal.valueOf(25).doubleValue(),result.doubleValue(), 0.0);
        Assert.assertEquals("Total shopping cost", customerCost.description());
    }


}
