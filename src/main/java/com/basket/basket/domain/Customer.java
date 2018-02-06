package com.basket.basket.domain;

import com.basket.basket.dbServices.CustomerBasket;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class Customer {

    private CustomerBasket customerBasket;

    public CustomerBasket openBasket() {
        return this.customerBasket;
    }

    public void scanItem(String name) {
        customerBasket.addEntry(new Item(1L,"milk", 3.0, 2));
    }

}
