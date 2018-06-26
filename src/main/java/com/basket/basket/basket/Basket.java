package com.basket.basket.basket;

import com.basket.basket.basketItem.BasketItems;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@Entity(name = "BASKET")
@Component
public class Basket {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
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

    public BigDecimal calculateTotal() {

        subtotal = BigDecimal.valueOf(this.getBasketItemsList().stream()
                .mapToDouble(m->m.getItem().getPrice()
                        .multiply(BigDecimal.valueOf(m.getQuantity())).doubleValue())
                .sum());

        return subtotal;
    }

}
