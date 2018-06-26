package com.basket.basket.dbServices;

import com.basket.basket.basket.BasketDao;
import com.basket.basket.basketItem.BasketItemsDao;
import com.basket.basket.item.ItemDao;
import com.basket.basket.basket.Basket;
import com.basket.basket.basketItem.BasketItems;
import com.basket.basket.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbService {

    private ItemDao itemDao;
    private BasketItemsDao basketItemsDao;
    private BasketDao basketDao;

    public DbService(ItemDao itemDao, BasketItemsDao basketItemsDao, BasketDao basketDao) {
        this.itemDao = itemDao;
        this.basketItemsDao = basketItemsDao;
        this.basketDao = basketDao;
    }

    public Optional<Item> getItemById(Long id) {
        return itemDao.findById(id);
    }

    public Optional<BasketItems> getBasketItemsById(Long id) {
        return basketItemsDao.findById(id);
    }

    public Optional<Basket> getBasketById(Long id) {
        return basketDao.findById(id);
    }

    public Optional<Item> getItemByName(String name) {
        return itemDao.findByName(name);
    }

    public Item saveItem(final Item item) {
        return itemDao.save(item);
    }

    public BasketItems saveBasketItem(final BasketItems basketItems) {
        return basketItemsDao.save(basketItems);
    }

    public Basket saveBasket(final Basket basket) {
        return basketDao.save(basket);
    }

    public void deleteItem(final Item item) {
        itemDao.delete(item);
    }

    public void deleteBasketItems(final BasketItems basketItems) {
        basketItemsDao.delete(basketItems);
    }

    public void deleteBasket(final Basket basket) {
        basketDao.delete(basket);
    }

}
