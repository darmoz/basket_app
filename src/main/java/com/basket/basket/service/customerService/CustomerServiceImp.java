package com.basket.basket.service.customerService;

import com.basket.basket.dao.BasketDao;
import com.basket.basket.dao.ItemDao;
import com.basket.basket.domain.Basket;
import com.basket.basket.domain.BasketItems;
import com.basket.basket.domain.Item;
import com.basket.basket.dto.BasketDto;
import com.basket.basket.dto.BasketItemsDto;
import com.basket.basket.exceptions.NoOpenBasketException;
import com.basket.basket.mapper.BasketItemMapperNoId;
import com.basket.basket.mapper.BasketMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImp.class);

    @Autowired
    private BasketDao basketDao;
    @Autowired
    private BasketMapper basketMapper;
    @Autowired
    private BasketItemMapperNoId basketItemMapperNoId;
    @Autowired
    private ItemDao itemDao;

    private boolean basketIsOpen = false;


    @Override
    public Basket saveBasket(BasketDto basketdto) {

        LOGGER.info("New basket has been opened");
        basketIsOpen=true;
        return basketDao.save(basketMapper.mapToBasket(basketdto));

    }

    @Override
    public void addToBasket(BasketItemsDto basketItemsDto) throws NoOpenBasketException {

        LOGGER.info("New item is about to be add to the basket");

        if(basketIsOpen) {
            Basket basket = basketDao.findBasketByBasketId(basketItemMapperNoId.mapToBasketItemsNoId(basketItemsDto)
                    .getBasket().getBasketId());
            Item item = itemDao.findByItemId(basketItemMapperNoId.mapToBasketItemsNoId(basketItemsDto).getItem()
                    .getItemId());
            basket.getBasketItemsList().add(new BasketItems(basket, item, basketItemsDto.getQuantity()));
            basketDao.save(basket);
        } else {
            LOGGER.warn("All basket are closed, please open new basket");
            throw new NoOpenBasketException();
        }
    }

    @Override
    public Basket closeBasket(BasketDto basketDto) {
        LOGGER.info("The basket has been closed");
        basketIsOpen=false;
        return basketDao.findBasketByBasketId(basketMapper.mapToBasket(basketDto).getBasketId());
    }

}
