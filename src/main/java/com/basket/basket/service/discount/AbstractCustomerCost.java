package com.basket.basket.service.discount;

import java.math.BigDecimal;

public abstract class AbstractCustomerCost implements CustomerCost {

    private final CustomerCost customerCost;

    protected AbstractCustomerCost(final CustomerCost customerCost) {
        this.customerCost = customerCost;
    }


    @Override
    public BigDecimal cost() {
        return customerCost.cost();
    }

    @Override
    public String description() {
        return customerCost.description();
    }

    public abstract String getItemName();

}
