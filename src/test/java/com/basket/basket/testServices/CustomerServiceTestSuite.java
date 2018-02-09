package com.basket.basket.testServices;

import com.basket.basket.dao.BasketDao;
import com.basket.basket.dao.BasketItemsDao;
import com.basket.basket.dao.ItemDao;
import com.basket.basket.domain.Basket;
import com.basket.basket.domain.BasketItems;
import com.basket.basket.domain.Item;
import com.basket.basket.dto.BasketDto;
import com.basket.basket.dto.BasketItemsDto;
import com.basket.basket.exceptions.NoOpenBasketException;
import com.basket.basket.mapper.BasketMapper;
import com.basket.basket.service.customerService.CustomerService;
import com.basket.basket.service.customerService.CustomerServiceImp;
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
public class CustomerServiceTestSuite {

    @Autowired
    private BasketDao basketDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private BasketItemsDao basketItemsDao;
    @Autowired
    private BasketMapper basketMapper;
    @Autowired
    private CustomerServiceImp customerServiceImp;

    @Test
    public void testSaveBasket() {
        //given
        long count = basketDao.count();
        BasketDto basketDto = new BasketDto(null);
        //when
        Basket basket = customerServiceImp.saveBasket(basketDto);
        //then
        Assert.assertEquals(count + 1, basketDao.count());
        //clean
        basketDao.delete(basket);
    }

    @Test
    public void testAddToBasket() throws NoOpenBasketException {
        //given
        BasketDto basketDto = new BasketDto(null);
        customerServiceImp.saveBasket(basketDto);

        Item item = new Item("test", BigDecimal.valueOf(2.5), 50);
        item = itemDao.save(item);
        //when
        Basket basket = customerServiceImp.addToBasket(item.getName(),20);
        //then
        Assert.assertEquals(1, basket.getBasketItemsList().size());
        //clean
        basketDao.delete(basket);
        itemDao.delete(item);
    }

    @Test(expected = NoOpenBasketException.class)
    public void testCloseBasket() throws NoOpenBasketException {
        //given
        BasketDto basketDto = new BasketDto(null);
        Basket basket = customerServiceImp.saveBasket(basketDto);
        //when
        customerServiceImp.closeBasket();
        customerServiceImp.closeBasket();
    }
}
