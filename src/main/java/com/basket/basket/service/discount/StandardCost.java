package com.basket.basket.service.discount;

import com.basket.basket.domain.Basket;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class StandardCost implements CustomerCost {

    @Autowired
    private Basket basket;

    @Override
    public BigDecimal cost() {
        return basket.calculateTotal();
    }

    @Override
    public String description() {
        return "Total shopping cost";
    }
}
