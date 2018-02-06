package com.basket.basket.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private long itemId;
    @Column(name = "ITEM_NAME", unique = true)
    private String name;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "UNIT_OF_ITEM")
    private int unit;


}
