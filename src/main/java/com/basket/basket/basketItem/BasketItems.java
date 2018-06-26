package com.basket.basket.basketItem;

import com.basket.basket.basket.Basket;
import com.basket.basket.item.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Optional;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BASKET_ITEMS")
@Component
public class BasketItems {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
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
    private Optional<Optional<Item>> item;

    public long getBasketItemId() {
        return basketItemsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Basket getBasket() {
        return basket;
    }

    public Optional<Optional<Optional<Item>>> getItem() {
        return Optional.of(item);
    }

    public void setItem(Optional<Item> item) {
        this.item = Optional.of(item);
    }
}
