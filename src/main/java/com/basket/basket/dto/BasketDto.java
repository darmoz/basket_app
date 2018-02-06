package com.basket.basket.dto;

import com.basket.basket.domain.BasketItems;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BasketDto {
    private long Id;
    private Date creationDate;
    private List<BasketItems> basketItemsList = new ArrayList<>();
}
