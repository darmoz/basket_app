package com.basket.basket.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@NoArgsConstructor
@Entity(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private long itemId;
    @Column(name = "ITEM_NAME", unique = true)
    private String name;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "UNIT")
    private int unit;

    public Item(final long itemId, final String name, final BigDecimal price, final int unit) {
        this.itemId=itemId;
        this.name=name;
        this.price=price;
        this.unit=unit;
    }

    public Item( final String name, final BigDecimal price, final int unit) {
        this.name=name;
        this.price=price;
        this.unit=unit;
    }

    public long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getUnit() {
        return unit;
    }

}
