package com.basket.basket.dto;

import com.basket.basket.domain.BasketItems;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BasketDto {
    private long basketId;
    private Date creationDate;
    private BigDecimal subtotal;
    private List<BasketItems> basketItemsList = new ArrayList<>();

    public BasketDto(final long basketId, final BigDecimal subtotal, final Date creationDate) {
        this.basketId=basketId;
        this.subtotal=subtotal;
        this.creationDate=creationDate;
        basketItemsList = new ArrayList<>();
    }

    public BasketDto(final Date creationDate) {
        this.creationDate=creationDate;
        basketItemsList = new ArrayList<>();
    }
}
