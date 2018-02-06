package com.basket.basket.domain;


import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@NoArgsConstructor
@Entity(name = "BASKET")
public class Basket {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long Id;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private List<BasketItems> basketItemsList = new ArrayList<>();

    public Basket() {
        creationDate = new Date();
    }

    public long getBasketId() {
        return Id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @OneToMany(
            targetEntity = BasketItems.class,
            mappedBy = "basket",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<BasketItems> getBasketItemsList() {
        return basketItemsList;
    }

}
