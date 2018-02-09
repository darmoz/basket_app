package com.basket.basket.controller;

import com.basket.basket.dbServices.DbService;
import com.basket.basket.dto.ItemDto;
import com.basket.basket.exceptions.ItemNotFoundException;
import com.basket.basket.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/item")
public class ItemController {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private DbService dbService;

    @RequestMapping(method = RequestMethod.GET, value = "getItem")
    public ItemDto getItem(@RequestParam Long itemId) throws ItemNotFoundException {
        return itemMapper.mapItemDto(dbService.getItemById(itemId).orElseThrow(ItemNotFoundException::new));}

    @RequestMapping(method = RequestMethod.POST, value = "createItem", consumes = APPLICATION_JSON_VALUE)
    public void createItem(@RequestBody ItemDto itemDto) { dbService.saveItem(itemMapper.mapItem(itemDto));}

    @RequestMapping(method = RequestMethod.PUT, value = "updateItem", consumes = APPLICATION_JSON_VALUE)
    public ItemDto updateTask(@RequestBody ItemDto itemDto) {return  itemMapper.mapItemDto(
            dbService.saveItem(itemMapper.mapItem(itemDto)));}

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteItem")
    public void deleteItem(@RequestParam Long itemId) throws ItemNotFoundException{
        dbService.deleteItem(dbService.getItemById(itemId).orElseThrow(ItemNotFoundException::new)); }
}
