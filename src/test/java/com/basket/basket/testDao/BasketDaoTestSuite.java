package com.basket.basket.testDao;

import com.basket.basket.dao.BasketDao;
import com.basket.basket.dao.ItemDao;
import com.basket.basket.domain.Basket;
import com.basket.basket.domain.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasketDaoTestSuite {
    @Autowired
    private BasketDao basketDao;

    @Test
    public void testGetBasketById() {
        //given
        Basket basket = new Basket(null);
        basket = basketDao.save(basket);
        //when
        Optional<Basket> retrievedBasket = basketDao.findById(basket.getBasketId());
        //then
        Assert.assertTrue(retrievedBasket.get()!=null);
        //clean up
        basketDao.delete(basket);
    }

    @Test
    public void deleteBasket() {
        //given
        Basket basket = new Basket(null);
        basket = basketDao.save(basket);
        //when
        basketDao.delete(basket);
        //then
        Assert.assertFalse(basketDao.findById(basket.getBasketId()).isPresent());
    }

    @Test
    public void saveBasket() {
        //given
        Basket basket = new Basket(null);
        //when
        basket = basketDao.save(basket);
        //then
        Assert.assertTrue(basketDao.findById(basket.getBasketId()).isPresent());
        //clean up
        basketDao.delete(basket);

    }
}
