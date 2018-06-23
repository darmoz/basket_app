package com.basket.basket.basket;

import com.basket.basket.basketItem.BasketItems;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
public class BasketDto {
    private long basketId;
    private Date creationDate;
    private BigDecimal subtotal;
    private List<BasketItems> basketItemsList = new ArrayList<>();

}
