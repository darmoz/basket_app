package com.basket.basket;

import com.basket.basket.controller.ItemController;
import com.basket.basket.dbServices.DbService;
import com.basket.basket.domain.Item;
import com.basket.basket.dto.ItemDto;
import com.basket.basket.mapper.ItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void getItem() throws Exception {
        //given
        Item item = new Item("milk",new BigDecimal(2.5), 10);
        item.setItemId(1L);
        ItemDto itemDto = new ItemDto("milk", new BigDecimal(2.5), 10);
        itemDto.setId(1L);
        //when & then
        when(dbService.getItemById(item.getId())).thenReturn(Optional.ofNullable(item));
        when(itemMapper.mapItemDto(item)).thenReturn(itemDto);

        mockMvc.perform(get("/v1/item/getItem?itemId={itemId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("milk"))
                .andExpect(jsonPath("$.itemId").value(1L));

    }

    @Test
    public void testDeleteItem() throws Exception {
        //given
        Item item = new Item("milk",new BigDecimal(2.5),10);
        item.setItemId(1L);
        ItemDto itemDto = new ItemDto("milk", new BigDecimal(2.5), 10);
        itemDto.setId(1L);
        when(dbService.getItemById(item.getId())).thenReturn(Optional.ofNullable(item));
        doNothing().when(dbService).deleteItem(item);
        //when & then
        mockMvc.perform(delete("/v1/item/deleteItem?id={id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
