package com.basket.basket.basket;

import com.basket.basket.dbServices.DbService;
import com.basket.basket.exceptions.ItemNotFoundException;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/basket")
public class BasketController {

    private final @NonNull BasketMapper basketMapper;

    private final @NonNull DbService dbService;

    public BasketController(BasketMapper basketMapper, DbService dbService) {
        this.basketMapper = basketMapper;
        this.dbService = dbService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBasket")
    public BasketDto getBasket(@RequestParam Long basketId) throws ItemNotFoundException {
        return basketMapper.mapToBasketDto(dbService.getBasketById(basketId)
                .orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBasket", consumes = APPLICATION_JSON_VALUE)
    public void createBasket(@RequestBody BasketDto basketDto) {
        dbService.saveBasket(basketMapper.mapToBasket(basketDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBasket")
    public BasketDto updateBasket(@RequestBody BasketDto basketDto) {
        return basketMapper.mapToBasketDto(
                dbService.saveBasket(basketMapper.mapToBasket(basketDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBasket")
    public void deleteBasket(@RequestParam Long basketId) throws ItemNotFoundException {
        dbService.deleteBasket(dbService.getBasketById(basketId).orElseThrow(ItemNotFoundException::new));
    }
}
