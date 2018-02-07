package com.basket.basket.domain;


import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

@Setter
@Entity(name = "BASKET")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long basketId;
    @Column(name = "SUBTOTAL")
    private BigDecimal subtotal;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @OneToMany(
            targetEntity = BasketItems.class,
            mappedBy = "basket",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<BasketItems> basketItemsList;

    public Basket() {
        creationDate = new Date();
        basketItemsList = new ArrayList<>();
    }

    public long getBasketId() {
        return basketId;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }
    public List<BasketItems> getBasketItemsList() {
        return this.basketItemsList;
    }

    public BigDecimal calculateTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for (BasketItems list : this.getBasketItemsList()) {
            total.add(list.getItem().getPrice().multiply(new BigDecimal(list.getQuantity())));
        }
        return total;
    }

}
