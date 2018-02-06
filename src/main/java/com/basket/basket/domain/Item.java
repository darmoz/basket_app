package com.basket.basket.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@NoArgsConstructor
@Entity(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID", unique = true)
    private long Id;
    @Column(name = "ITEM_NAME", unique = true)
    private String name;
    @Column(name = "PRICE")
    private double price;
    private BasketItems basketItems;

    public Item(final String name, final double price) {
        this.name=name;
        this.price=price;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BASKET_ITEMS_ID")
    public BasketItems getBasketItems() {
        return basketItems;
    }
}
