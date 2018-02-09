package com.basket.basket.testController;

import com.basket.basket.controller.BasketController;
import com.basket.basket.dbServices.DbService;
import com.basket.basket.domain.Basket;
import com.basket.basket.dto.BasketDto;
import com.basket.basket.mapper.BasketMapper;
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
@WebMvcTest(BasketController.class)
public class BasketControllerTestSuite {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private BasketMapper basketMapper;


    @Test
    public void testGetBasket() throws Exception {
        //given
        BasketDto basketDto = new BasketDto(1L, BigDecimal.valueOf(10), null);
        Basket basket = new Basket(1L, BigDecimal.valueOf(10), null);


        //when & then
        when(dbService.getBasketById(basket.getBasketId())).thenReturn(Optional.ofNullable(basket));
        when(basketMapper.mapToBasketDto(basket)).thenReturn(basketDto);
        mockMvc.perform(get("/v1/basket/getBasket?basketId={basketId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.basketId", is(1)))
                .andExpect(jsonPath("$.subtotal", is(10)));
    }

    @Test
    public void testDeleteBaskt() throws Exception {
        //given
        BasketDto basketDto = new BasketDto(1L, BigDecimal.valueOf(1), null);
        Basket basket = new Basket(1L, BigDecimal.valueOf(1), null);

        when(dbService.getBasketById(basket.getBasketId())).thenReturn(Optional.ofNullable(basket));
        doNothing().when(dbService).deleteBasket(basket);
        //when & then
        mockMvc.perform(delete("/v1/basket/deleteBasket?basketId={basketId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testPostBasket() throws Exception {
        //given
        Basket basket = new Basket(1L, BigDecimal.valueOf(1), null);
        BasketDto basketDto = new BasketDto(1L, BigDecimal.valueOf(1), null);

        when(basketMapper.mapToBasket(basketDto)).thenReturn(basket);
        when(dbService.saveBasket(ArgumentMatchers.any(Basket.class))).thenReturn(basket);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(basket);
        // when & then
        mockMvc.perform(post("/v1/basket/createBasket").contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void testPutBasket() throws Exception {
        //given
        Basket basket = new Basket(1L, BigDecimal.valueOf(1), null);
        BasketDto basketDto = new BasketDto(1L, BigDecimal.valueOf(1), null);

        when(basketMapper.mapToBasket(ArgumentMatchers.any(BasketDto.class))).thenReturn(basket);
        when(dbService.saveBasket(ArgumentMatchers.any(Basket.class))).thenReturn(basket);
        when(basketMapper.mapToBasketDto(ArgumentMatchers.any(Basket.class))).thenReturn(basketDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(basket);
        // when & then
        mockMvc.perform(put("/v1/basket/updateBasket").contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.basketId", is(1)))
                .andExpect(jsonPath("$.subtotal", is(1)));
    }
}

