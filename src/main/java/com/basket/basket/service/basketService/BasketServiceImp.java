package com.basket.basket.service.basketService;

import com.basket.basket.dao.BasketDao;
import com.basket.basket.dao.BasketItemsDao;
import com.basket.basket.dao.ItemDao;
import com.basket.basket.dbServices.CustomerBasket;
import com.basket.basket.domain.Basket;
import com.basket.basket.domain.BasketItems;
import com.basket.basket.domain.Item;
import com.basket.basket.dto.BasketDto;
import com.basket.basket.dto.BasketItemsDto;
import com.basket.basket.mapper.BasketItemsMapper;
import com.basket.basket.mapper.BasketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BasketServiceImp implements BasketService {

    @Autowired
    private BasketDao basketDao;
    @Autowired
    private BasketMapper basketMapper;
    @Autowired
    private BasketItemsMapper basketItemsMapper;
    @Autowired
    private ItemDao itemDao;

    @Override
    public Basket saveBasket(BasketDto basketdto) {
        return basketDao.save(basketMapper.mapToBasket(basketdto));
    }

    @Override
    public void addToBasket(BasketItemsDto basketItemsDto) {
        Basket basket = basketDao.findBasketByBasketId(basketItemsMapper.mapToBasketItems(basketItemsDto).getBasket().getBasketId());
        Item item = itemDao.findByItemId(basketItemsMapper.mapToBasketItems(basketItemsDto).getItem().getId());
        basket.getBasketItemsList().add(new BasketItems(basket, item, basketItemsDto.getQuantity()));
        basketDao.save(basket);

    }

    @Override
    public Basket closeBasket(BasketDto basketDto) {
        return basketDao.findBasketByBasketId(basketMapper.mapToBasket(basketDto).getBasketId());
    }

}
