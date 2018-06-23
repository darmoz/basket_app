package com.basket.basket.service.discount;

import com.basket.basket.basket.Basket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class StandardCost implements CustomerCost {

    private static final Logger LOGGER = LoggerFactory.getLogger(StandardCost.class);

    private Basket basket;

    public StandardCost(final Basket basket) {
        this.basket = basket;
    }

    @Override
    public BigDecimal cost() {

        LOGGER.info("Calculate cost of the basket");
        return basket.calculateTotal();
    }

    @Override
    public String description() {
        return "Total shopping cost";
    }
}
