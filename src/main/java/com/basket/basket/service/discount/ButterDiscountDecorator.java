package com.basket.basket.service.discount;

import com.basket.basket.domain.BasketItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class ButterDiscountDecorator extends AbstractCustomerCost {

    private static final Logger LOGGER = LoggerFactory.getLogger(ButterDiscountDecorator.class);

    private BasketItems basketItems;

    protected ButterDiscountDecorator(CustomerCost customerCost, BasketItems basketItems) {
        super(customerCost);
        this.basketItems=basketItems;
    }

    @Override
    public BigDecimal cost() {

        LOGGER.info("Discount for butter has been included");
        if(basketItems.getItem().getName().equals("butter") && basketItems.getQuantity()>=10) {
            return super.cost().subtract((new BigDecimal(basketItems.getQuantity())
                    .multiply(basketItems.getItem().getPrice()))
                    .multiply(new BigDecimal(0.01)));
        } else {
            return null;
        }

    }

    @Override
    public String description() {
        return " - [1% of butter price]";
    }
}
