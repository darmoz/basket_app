package com.basket.basket.service.discount;

import com.basket.basket.domain.BasketItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class BreadDiscountDecorator extends AbstractCustomerCost {

    private static final Logger LOGGER = LoggerFactory.getLogger(BreadDiscountDecorator.class);

    private BasketItems basketItems;

    public BreadDiscountDecorator(CustomerCost customerCost, BasketItems basketItems) {
        super(customerCost);
        this.basketItems=basketItems;
    }

    @Override
    public BigDecimal cost() {

        LOGGER.info("Discount for bread has been included");
        if(basketItems.getItem().getName().equals(getItemName()) && basketItems.getQuantity()>=20) {
            return super.cost().subtract((BigDecimal.valueOf(basketItems.getQuantity())
                    .multiply(basketItems.getItem().getPrice()))
                    .multiply(BigDecimal.valueOf(0.05)));
        } else {
            return super.cost();
        }

    }

    @Override
    public String description() {
        if(basketItems.getItem().getName().equals(getItemName()) && basketItems.getQuantity()>=20) {
            return String.format(super.description() + " - [5%% of %s price]", getItemName());
        } else {
            return super.description();
        }
    }

    @Override
    public String getItemName() {
        return "bread";
    }
}
