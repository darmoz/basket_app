package com.basket.basket.dbServices;

import com.basket.basket.dao.BasketDao;
import com.basket.basket.dao.BasketItemsDao;
import com.basket.basket.dao.ItemDao;
import com.basket.basket.domain.Basket;
import com.basket.basket.domain.BasketItems;
import com.basket.basket.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private BasketItemsDao basketItemsDao;
    @Autowired
    private BasketDao basketDao;

    public Optional<Item> getItemById(Long id) {return itemDao.findById(id);}
    public Optional<BasketItems> getBasketItemsById(Long id) {return basketItemsDao.findById(id);}
    public Optional<Basket> getBasketById(Long id) {return basketDao.findById(id);}

    public Optional<Item> getItemByName(String name) {return itemDao.findByName(name);}

    public Item saveItem(final Item item) {return itemDao.save(item);}
    public BasketItems saveBasketItem(final BasketItems basketItems) {return basketItemsDao.save(basketItems);}
    public Basket saveBasket(final Basket basket) {return basketDao.save(basket);}

    public void deleteItem(final Item item) { itemDao.delete(item);}
    public void deleteBasketItems(final BasketItems basketItems) {basketItemsDao.delete(basketItems);}
    public void deleteBasket(final Basket basket) {basketDao.delete(basket);}

}
