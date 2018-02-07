package com.basket.basket.service.discount;

import com.basket.basket.domain.BasketItems;

import java.math.BigDecimal;


public class MilkDiscountDecorator extends AbstractCustomerCost {


    private BasketItems basketItems;

    protected MilkDiscountDecorator(CustomerCost customerCost) {
        super(customerCost);
    }
    @Override
    public BigDecimal cost() {
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
        return "Total shopping cost";
    }

}
