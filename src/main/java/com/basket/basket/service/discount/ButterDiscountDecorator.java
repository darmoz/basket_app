package com.basket.basket.service.discount;

import com.basket.basket.basketItem.BasketItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class ButterDiscountDecorator extends AbstractCustomerCost {

    private static final Logger LOGGER = LoggerFactory.getLogger(ButterDiscountDecorator.class);

    private BasketItems basketItems;

    public ButterDiscountDecorator(CustomerCost customerCost, BasketItems basketItems) {
        super(customerCost);
        this.basketItems = basketItems;
    }

    @Override
    public BigDecimal cost() {

        LOGGER.info("Discount for butter has been included");
        if (basketItems.getItem().getName().equals(getItemName()) && basketItems.getQuantity() >= 10) {
            return super.cost().subtract((BigDecimal.valueOf(basketItems.getQuantity())
                    .multiply(basketItems.getItem().getPrice()))
                    .multiply(BigDecimal.valueOf(0.01)));
        } else {
            return super.cost();
        }


    }

    @Override
    public String description() {
        if (basketItems.getItem().getName().equals(getItemName()) && basketItems.getQuantity() >= 10) {
            return String.format(super.description() + " - [1%% of %s price]", getItemName());
        } else {
            return super.description();
        }
    }

    @Override
    public String getItemName() {
        return "butter";
    }
}
