package com.basket.basket.service.discount;

import com.basket.basket.domain.BasketItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


public class MilkDiscountDecorator extends AbstractCustomerCost {

    private static final Logger LOGGER = LoggerFactory.getLogger(MilkDiscountDecorator.class);

    private BasketItems basketItems;

    protected MilkDiscountDecorator(CustomerCost customerCost, BasketItems basketItems) {
        super(customerCost);
        this.basketItems=basketItems;
    }

    @Override
    public BigDecimal cost() {

        LOGGER.info("Discount for milk has been included");
        if(basketItems.getItem().getName().equals("milk") && basketItems.getQuantity()>=70) {
            return super.cost().subtract((new BigDecimal(basketItems.getQuantity())
                    .multiply(basketItems.getItem().getPrice()))
                    .multiply(new BigDecimal(0.1)));
        } else {
            return null;
        }

    }

    @Override
    public String description() {
        return " - [10% of milk price]";
    }

}
