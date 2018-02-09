package com.basket.basket.service.discount;

import com.basket.basket.domain.BasketItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


public class MilkDiscountDecorator extends AbstractCustomerCost {

    private static final Logger LOGGER = LoggerFactory.getLogger(MilkDiscountDecorator.class);

    private BasketItems basketItems;

    public MilkDiscountDecorator(CustomerCost customerCost, BasketItems basketItems) {
        super(customerCost);
        this.basketItems = basketItems;
    }

    @Override
    public BigDecimal cost() {

        LOGGER.info("Discount for milk has been included");
        if (basketItems.getItem().getName().equals("milk") && basketItems.getQuantity() >= 70) {
            return super.cost().subtract((BigDecimal.valueOf(basketItems.getQuantity())
                    .multiply(basketItems.getItem().getPrice()))
                    .multiply(BigDecimal.valueOf(0.1)));
        } else {
            return super.cost();
        }

    }

    @Override
    public String description() {
        if (basketItems.getItem().getName().equals("milk") && basketItems.getQuantity() >= 70) {
            return String.format(super.description() + " - [10%% of %s price]", getItemName());
        } else {
            return super.description();
        }
    }

    @Override
    public String getItemName() {
        return "milk";
    }
}
