package com.basket.basket.testController;

import com.basket.basket.item.ItemController;
import com.basket.basket.dbServices.DbService;
import com.basket.basket.item.Item;
import com.basket.basket.item.ItemDto;
import com.basket.basket.item.ItemMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private ItemMapper itemMapper;

    @Test
    public void testGetItem() throws Exception {
        //given
        ItemDto itemDto = new ItemDto(1L, "test", BigDecimal.valueOf(1), 10);
        Item item = new Item(1L, "test", BigDecimal.valueOf(1), 10);

        //when & then
        when(dbService.getItemById(item.getItemId())).thenReturn(Optional.ofNullable(item));
        when(itemMapper.mapItemDto(item)).thenReturn(itemDto);
        mockMvc.perform(get("/v1/item/getItem?itemId={itemId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.itemId", is(1)))
                .andExpect(jsonPath("$.name", is("test")))
                .andExpect(jsonPath("$.price", is(1)))
                .andExpect(jsonPath("$.unit", is(10)));
    }

    @Test
    public void testDeleteItem() throws Exception {
        //given
        //given
        ItemDto itemDto = new ItemDto(1L, "test", BigDecimal.valueOf(1), 10);
        Item item = new Item(1L, "test", BigDecimal.valueOf(1), 10);

        when(dbService.getItemById(item.getItemId())).thenReturn(Optional.ofNullable(item));
        doNothing().when(dbService).deleteItem(item);
        //when & then
        mockMvc.perform(delete("/v1/item/deleteItem?itemId={itemId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testPostItem() throws Exception {
        //given
        Item item = new Item(1L, "test", BigDecimal.valueOf(1), 10);
        ItemDto itemDto = new ItemDto(1L, "test", BigDecimal.valueOf(1), 10);

        when(itemMapper.mapItem(itemDto)).thenReturn(item);
        when(dbService.saveItem(ArgumentMatchers.any(Item.class))).thenReturn(item);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(item);
        // when & then
        mockMvc.perform(post("/v1/item/createItem").contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void testPutItem() throws Exception {
        //given
        Item item = new Item(1L, "test", BigDecimal.valueOf(1), 10);
        ItemDto itemDto = new ItemDto(1L, "test", BigDecimal.valueOf(1), 10);

        when(itemMapper.mapItem(ArgumentMatchers.any(ItemDto.class))).thenReturn(item);
        when(dbService.saveItem(ArgumentMatchers.any(Item.class))).thenReturn(item);
        when(itemMapper.mapItemDto(ArgumentMatchers.any(Item.class))).thenReturn(itemDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(item);
        // when & then
        mockMvc.perform(put("/v1/item/updateItem").contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.itemId", is(1)))
                .andExpect(jsonPath("$.name", is("test")))
                .andExpect(jsonPath("$.price", is(1)))
                .andExpect(jsonPath("$.unit", is(10)));
    }
}
