package com.basket.basket;

import com.basket.basket.dao.ItemDao;
import com.basket.basket.domain.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemDaoTestSuite {
    @Autowired
    private ItemDao itemDao;

    @Test
    public void testGetItemById() {
        //given
        Item item = new Item(1L,"milk",new BigDecimal(2.5), 10);
        itemDao.save(item);
        //when
        long id = itemDao.findByName("milk").get().getItemId();
        String name = itemDao.findById(id).get().getName();
        //then
        Assert.assertEquals(item.getName(), name);
        //clean up
        itemDao.delete(item);
    }
    @Test
    public void testGetItemByName() {
        //given
        Item item = new Item(1L,"milk",new BigDecimal(2.5), 10);
        itemDao.save(item);
        //when
        long id = itemDao.findByName("milk").get().getItemId();
        //then
        Assert.assertEquals(item.getItemId(), id);
        //clean up
        itemDao.delete(item);
    }

    @Test
    public void deleteItem() {
        //given
        Item item = new Item(1L,"milk",new BigDecimal(2.5), 10);
        itemDao.save(item);
        //when
        itemDao.delete(item);
        //then
        Assert.assertFalse(itemDao.findByName("milk").isPresent());
    }
}
