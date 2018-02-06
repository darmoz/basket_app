package com.basket.basket.controller;

import com.basket.basket.dbServices.CustomerBasket;
import com.basket.basket.domain.BasketItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/manbasket")
public class BasketManController {
    @Autowired
    private BasketItemsController basketItemsController;

    private CustomerBasket customerBasket = CustomerBasket.getInstance();

    @RequestMapping(method = RequestMethod.POST, value = "getBasket")
    public CustomerBasket createBasket() {return customerBasket;}

    @RequestMapping(method = RequestMethod.PUT, value = "addItem")
    public CustomerBasket addItemToBasket() { return customerBasket.addEntry(); }
}
