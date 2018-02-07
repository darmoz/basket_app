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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long basketItemsId;
    @Column(name = "QUANTITY")
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basketId")
    private Basket basket;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "itemId")
    private Item item;

    public BasketItems(final long basketItemsId, final Basket basket, final Item item, final int quantity) {
        this.basketItemsId=basketItemsId;
        this.quantity=quantity;
        this.basket=basket;
        this.item=item;
    }

    public long getBasketItemId() {
        return basketItemsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Basket getBasket() {
        return basket;
    }

    public Item getItem() {
        return item;
    }
}
