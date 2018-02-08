package com.basket.basket.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BASKET_ITEMS")
public class BasketItems {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private long basketItemsId;
    @Column(name = "QUANTITY")
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basketId")
    private Basket basket;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itemId")
    private Item item;

    public BasketItems(final long basketItemsId, final int quantity) {
        this.basketItemsId=basketItemsId;
        this.quantity=quantity;
    }

    public BasketItems(final int quantity) {
        this.quantity=quantity;

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
