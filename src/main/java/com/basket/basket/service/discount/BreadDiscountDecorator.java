package com.basket.basket.service.discount;

import com.basket.basket.domain.BasketItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class BreadDiscountDecorator extends AbstractCustomerCost {

    private static final Logger LOGGER = LoggerFactory.getLogger(BreadDiscountDecorator.class);

    private BasketItems basketItems;

    protected BreadDiscountDecorator(CustomerCost customerCost, BasketItems basketItems) {
        super(customerCost);
        this.basketItems=basketItems;
    }

    @Override
    public BigDecimal cost() {

        LOGGER.info("Discount for bread has been included");
        if(basketItems.getItem().getName().equals("bread") && basketItems.getQuantity()>=20) {
            return super.cost().subtract((new BigDecimal(basketItems.getQuantity())
                    .multiply(basketItems.getItem().getPrice()))
                    .multiply(new BigDecimal(0.05)));
        } else {
            return null;
        }

    }

    @Override
    public String description() {
        return " - [5% of bread price]";
    }

}
