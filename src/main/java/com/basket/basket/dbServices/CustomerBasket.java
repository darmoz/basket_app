package com.basket.basket.dbServices;

import com.basket.basket.domain.BasketItems;
import com.basket.basket.domain.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerBasket {

        private static CustomerBasket customerBasketInstance = null;
        List<BasketItems> basket = new ArrayList<>();

        private CustomerBasket() {
        }

        public static CustomerBasket getInstance() {
            if(customerBasketInstance==null) {
                customerBasketInstance = new CustomerBasket();
            }
            return customerBasketInstance;
        }

        public BasketItems getEntry(int i) {return basket.get(i);}


        public void addEntry(BasketItems basketItems) {
            basket.add(basketItems);


    }
}
