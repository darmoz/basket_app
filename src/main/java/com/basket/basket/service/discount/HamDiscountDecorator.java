package com.basket.basket.service.discount;

import com.basket.basket.domain.BasketItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class HamDiscountDecorator extends AbstractCustomerCost {

    private static final Logger LOGGER = LoggerFactory.getLogger(HamDiscountDecorator.class);

    private BasketItems basketItems;

    public HamDiscountDecorator(CustomerCost customerCost, BasketItems basketItems) {
        super(customerCost);
        this.basketItems=basketItems;
    }

    @Override
    public BigDecimal cost() {

        LOGGER.info("Discount for ham has been included");
        if(basketItems.getItem().getName().equals(getItemName()) && basketItems.getQuantity()>=10) {
            return super.cost().subtract((BigDecimal.valueOf(basketItems.getQuantity())
                    .multiply(basketItems.getItem().getPrice()))
                    .multiply(BigDecimal.valueOf(0.02)));
        } else {
            return super.cost();
        }

    }

    @Override
    public String description() {
        if(basketItems.getItem().getName().equals(getItemName()) && basketItems.getQuantity()>=10) {
            return String.format(super.description() + " - [2%% of %s price]", getItemName());
        } else {
            return super.description();
        }
    }

    @Override
    public String getItemName() {
        return "ham";
    }
}
