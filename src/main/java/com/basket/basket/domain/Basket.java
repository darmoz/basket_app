package com.basket.basket.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@Entity(name = "BASKET")
public class Basket {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
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

    public Basket(final long basketId, final BigDecimal subtotal, final Date creationDate) {
        this.basketId=basketId;
        this.subtotal=subtotal;
        this.creationDate=creationDate;
        basketItemsList = new ArrayList<>();
    }

    public Basket(final Date creationDate) {
        this.creationDate=creationDate;
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
        subtotal = BigDecimal.ZERO;
        for (BasketItems list : this.getBasketItemsList()) {
            subtotal = subtotal.add(list.getItem().getPrice().multiply(BigDecimal.valueOf(list.getQuantity())));
        }
        return subtotal;
    }

}
