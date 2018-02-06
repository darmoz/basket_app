package com.basket.basket.dbServices;

import com.basket.basket.domain.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerBasket {

        private static CustomerBasket customerBasketInstance = null;
        List<Item> itemList = new ArrayList<>();

        private CustomerBasket() {
        }

        public static CustomerBasket getInstance() {
            if(customerBasketInstance==null) {
                customerBasketInstance = new CustomerBasket();
            }
            return customerBasketInstance;
        }

        public Item getEntry(int i) {return itemList.get(i);}


        public void addEntry(Item item) {
            itemList.add(item);


    }
}
