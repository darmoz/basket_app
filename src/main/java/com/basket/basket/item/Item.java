package com.basket.basket.item;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@Entity(name = "ITEMS")
@Component
public class Item {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
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
