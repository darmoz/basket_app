package com.basket.basket.testDao;

import com.basket.basket.dao.BasketDao;
import com.basket.basket.dao.BasketItemsDao;
import com.basket.basket.dao.ItemDao;
import com.basket.basket.domain.Basket;
import com.basket.basket.domain.BasketItems;
import com.basket.basket.domain.Item;
import com.basket.basket.dto.BasketDto;
import com.basket.basket.dto.ItemDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasketItemsDaoTestSuite {

    @Autowired
    private BasketItemsDao basketItemsDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private BasketDao basketDao;

    @Test
    public void testGetBasketItemById() {
        //given
        Basket basket = new Basket(new Date());
        basketDao.save(basket);
        Item item = new Item("milk", new BigDecimal(2.5),50);
        itemDao.save(item);
        //when
        BasketItems basketItems = new BasketItems(10);
        basketItems.setItem(item);
        basketItems.setBasket(basket);
        basketItemsDao.save(basketItems);
        int retrievedQuantity = basketItemsDao.findById(1L).get().getQuantity();
        //then
        Assert.assertEquals(10, retrievedQuantity);
        //clean up
        basketItemsDao.delete(basketItems);
        itemDao.delete(item);
        basketDao.delete(basket);
    }

    @Test
    public void testDeleteBasketItems() {
        //given
        Basket basket = new Basket(new Date());
        basketDao.save(basket);
        Item item = new Item("milk", new BigDecimal(2.5),50);
        itemDao.save(item);
        BasketItems basketItems = new BasketItems(10);
        basketItems.setItem(item);
        basketItems.setBasket(basket);
        basketItemsDao.save(basketItems);
        //when
        basketItemsDao.delete(basketItems);
        long count = basketItemsDao.count();
        //then
        Assert.assertEquals(0,count);
        //clean up
        itemDao.delete(item);
        basketDao.delete(basket);
    }
}
