package com.basket.basket.basketItem;

import com.basket.basket.dbServices.DbService;
import com.basket.basket.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/v1/basketItems")
public class BasketItemsController {

    private final BasketItemsMapper basketItemsMapper;

    private final DbService dbService;

    @RequestMapping(method = RequestMethod.GET, value = "getBasketItem")
    public BasketItemsDto getBasketItem(@RequestParam Long basketItemId) throws ItemNotFoundException {
        return basketItemsMapper.mapToBasketItemsDto(dbService.getBasketItemsById(basketItemId)
                .orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBasketItem", consumes = APPLICATION_JSON_VALUE)
    public void createBasketItem(@RequestBody BasketItemsDto basketItemsDto) {
        dbService.saveBasketItem(basketItemsMapper.mapToBasketItems(basketItemsDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBasketItem")
    public BasketItemsDto updateBasketItem(@RequestBody BasketItemsDto basketItemsDto) {
        return basketItemsMapper.mapToBasketItemsDto(
                dbService.saveBasketItem(basketItemsMapper.mapToBasketItems(basketItemsDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBasketItem")
    public void deleteBasketItem(@RequestParam Long basketItemId) throws ItemNotFoundException {
        dbService.deleteBasketItems(dbService.getBasketItemsById(basketItemId).orElseThrow(ItemNotFoundException::new));
    }
}
