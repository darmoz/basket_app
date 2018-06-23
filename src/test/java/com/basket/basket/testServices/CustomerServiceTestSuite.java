package com.basket.basket.testServices;

import com.basket.basket.basket.BasketDao;
import com.basket.basket.basketItem.BasketItemsDao;
import com.basket.basket.item.ItemDao;
import com.basket.basket.basket.Basket;
import com.basket.basket.item.Item;
import com.basket.basket.basket.BasketDto;
import com.basket.basket.exceptions.NoOpenBasketException;
import com.basket.basket.basket.BasketMapper;
import com.basket.basket.service.customerService.CustomerServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

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
        Basket basket = customerServiceImp.addToBasket(item.getName(), 20);
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
