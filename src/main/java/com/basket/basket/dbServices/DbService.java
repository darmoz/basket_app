package com.basket.basket.dbServices;

import com.basket.basket.dao.ItemDao;
import com.basket.basket.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private ItemDao itemDao;

    public Optional<Item> getItemById(Long id) {return itemDao.findById(id);}

    public Item saveItem(final Item item) {return itemDao.save(item);}

    public void deleteItem(final Item item) { itemDao.delete(item);}

}
