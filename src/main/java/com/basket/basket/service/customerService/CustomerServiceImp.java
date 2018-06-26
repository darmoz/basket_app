package com.basket.basket.service.customerService;

import com.basket.basket.basket.BasketDao;
import com.basket.basket.item.ItemDao;
import com.basket.basket.basket.Basket;
import com.basket.basket.basketItem.BasketItems;
import com.basket.basket.item.Item;
import com.basket.basket.basket.BasketDto;
import com.basket.basket.exceptions.NoOpenBasketException;
import com.basket.basket.basket.BasketMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImp.class);

    private BasketDao basketDao;
    private BasketMapper basketMapper;
    private ItemDao itemDao;
    private Basket basket;
    private boolean basketIsOpen = false;

    public CustomerServiceImp(BasketDao basketDao, BasketMapper basketMapper, ItemDao itemDao, Basket basket) {
        this.basketDao = basketDao;
        this.basketMapper = basketMapper;
        this.itemDao = itemDao;
        this.basket = basket;
    }

    @Override
    public Basket saveBasket(BasketDto basketdto) {
        LOGGER.info("New basket has been opened");
        basketIsOpen = true;
        basket = basketDao.save(basketMapper.mapToBasket(basketdto));
        return basket;
    }

    @Override
    public Basket addToBasket(String itemName, int quantity) throws NoOpenBasketException {
        LOGGER.info("New item is about to be add to the basket");
        if (basketIsOpen) {
            Optional<Item> item = itemDao.findByName(itemName);

            BasketItems basketItems = BasketItems.builder()
                    .quantity(quantity)
                    .build();
            basketItems.getBasket().getBasketItemsList().add(basketItems);
            basketItems.setItem(item);

            basket.getBasketItemsList().add(basketItems);
            return basketDao.save(basket);
        } else {
            LOGGER.warn("All basket are closed, please open new basket");
            throw new NoOpenBasketException();
        }
    }

    @Override
    public Basket closeBasket() throws NoOpenBasketException {
        LOGGER.info("The basket has been closed");
        if (basketIsOpen) {
            basketIsOpen = false;
            return basket;
        } else {
            LOGGER.warn("All basket are closed, please open new basket");
            throw new NoOpenBasketException();
        }
    }

}
