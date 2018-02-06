package com.basket.basket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@NoArgsConstructor
@Entity(name = "BASKET_ITEMS")
public class BasketItems {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long Id;
    @Column(name = "QUANTITY")
    private int quantity;
    private Basket basket;

    public BasketItems(final int quantity) {
        this.quantity=quantity;
    }

    public long getBasketItemId() {
        return Id;
    }

    public int getQuantity() {
        return quantity;
    }
    @ManyToOne
    @JoinColumn(name = "BASKET_ID")
    public Basket getBasket() {
        return basket;
    }
}
