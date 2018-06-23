package com.basket.basket.testController;

import com.basket.basket.basketItem.BasketItemsController;
import com.basket.basket.dbServices.DbService;
import com.basket.basket.basketItem.BasketItems;
import com.basket.basket.basketItem.BasketItemsDto;
import com.basket.basket.basketItem.BasketItemsMapper;
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

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BasketItemsController.class)
public class BasketItemsControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private BasketItemsMapper basketItemsMapper;


    @Test
    public void testGetBasketItems() throws Exception {
        //given
        BasketItemsDto basketItemsDto = new BasketItemsDto(1L, 10);
        BasketItems basketItems = new BasketItems(1L, 10);


        //when & then
        when(dbService.getBasketItemsById(basketItems.getBasketItemId())).thenReturn(Optional.ofNullable(basketItems));
        when(basketItemsMapper.mapToBasketItemsDto(basketItems)).thenReturn(basketItemsDto);
        mockMvc.perform(get("/v1/basketItems/getBasketItem?basketItemId={basketItemsId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.basketItemId", is(1)))
                .andExpect(jsonPath("$.quantity", is(10)));
    }

    @Test
    public void testDeleteBaskt() throws Exception {
        //given
        BasketItemsDto basketItemsDto = new BasketItemsDto(1L, 5);
        BasketItems basketItems = new BasketItems(1L, 5);

        when(dbService.getBasketItemsById(basketItems.getBasketItemId())).thenReturn(Optional.ofNullable(basketItems));
        doNothing().when(dbService).deleteBasketItems(basketItems);
        //when & then
        mockMvc.perform(delete("/v1/basketItems/deleteBasketItem?basketItemId={basketItemsId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testPostBasketItems() throws Exception {
        //given
        BasketItems basketItems = new BasketItems(1L, 20);
        BasketItemsDto basketItemsDto = new BasketItemsDto(1L, 20);

        when(basketItemsMapper.mapToBasketItems(basketItemsDto)).thenReturn(basketItems);
        when(dbService.saveBasketItem(ArgumentMatchers.any(BasketItems.class))).thenReturn(basketItems);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(basketItems);
        // when & then
        mockMvc.perform(post("/v1/basketItems/createBasketItem").contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void testPutBasketItems() throws Exception {
        //given
        BasketItems basketItems = new BasketItems(1L, 1);
        BasketItemsDto basketItemsDto = new BasketItemsDto(1L, 1);

        when(basketItemsMapper.mapToBasketItems(ArgumentMatchers.any(BasketItemsDto.class))).thenReturn(basketItems);
        when(dbService.saveBasketItem(ArgumentMatchers.any(BasketItems.class))).thenReturn(basketItems);
        when(basketItemsMapper.mapToBasketItemsDto(ArgumentMatchers.any(BasketItems.class))).thenReturn(basketItemsDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(basketItems);
        // when & then
        mockMvc.perform(put("/v1/basketItems/updateBasketItem").contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.basketItemId", is(1)))
                .andExpect(jsonPath("$.quantity", is(1)));
    }
}
