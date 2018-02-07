package com.basket.basket.service.discount;

import com.basket.basket.dao.BasketItemsDao;
import com.basket.basket.domain.Basket;
import com.basket.basket.domain.BasketItems;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

public class MilkDiscountDecorator extends AbstractCustomerCost {

    @Autowired
    private Optional<BasketItems>  basketItems;
    @Autowired
    private BasketItemsDao basketItemsDao;

    private BigDecimal discountedCost;

    protected MilkDiscountDecorator(CustomerCost customerCost) {
        super(customerCost);
    }
    @Override
    public BigDecimal cost() {
        basketItems = basketItemsDao.findById(basketItems.get().getBasketItemId());
        if(basketItems.get().getItem().getName().equals("milk") && basketItems.get().getQuantity()>=70) {
            discountedCost = super.cost().subtract((new BigDecimal(basketItems.get().getQuantity())
                    .multiply(basketItems.get().getItem().getPrice()))
                    .multiply(new BigDecimal(0.1)));
        }
        return discountedCost;
    }

    @Override
    public String description() {
        return "Total shopping cost";
    }

}
