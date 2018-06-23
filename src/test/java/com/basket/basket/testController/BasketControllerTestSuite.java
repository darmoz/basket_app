package com.basket.basket.testController;

import com.basket.basket.basket.BasketController;
import com.basket.basket.dbServices.DbService;
import com.basket.basket.basket.Basket;
import com.basket.basket.basket.BasketDto;
import com.basket.basket.basket.BasketMapper;
import com.google.gson.Gson;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BasketControllerTestSuite {

    private final @NonNull MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private BasketMapper basketMapper;


    @Test
    public void testGetBasket() throws Exception {
        //given
        BasketDto basketDto = BasketDto.builder()
                .basketId(1L)
                .subtotal(BigDecimal.valueOf(10))
                .basketItemsList(null)
                .build();

        Basket basket = Basket.builder()
                .basketId(1L)
                .subtotal(BigDecimal.valueOf(10))
                .basketItemsList(null)
                .build();


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

        Basket basket = Basket.builder()
                .basketId(1L)
                .subtotal(BigDecimal.valueOf(1))
                .basketItemsList(null)
                .build();

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
        BasketDto basketDto = BasketDto.builder()
                .basketId(1L)
                .subtotal(BigDecimal.valueOf(1))
                .basketItemsList(null)
                .build();

        Basket basket = Basket.builder()
                .basketId(1L)
                .subtotal(BigDecimal.valueOf(1))
                .basketItemsList(null)
                .build();

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
        BasketDto basketDto = BasketDto.builder()
                .basketId(1L)
                .subtotal(BigDecimal.valueOf(1))
                .basketItemsList(null)
                .build();

        Basket basket = Basket.builder()
                .basketId(1L)
                .subtotal(BigDecimal.valueOf(1))
                .basketItemsList(null)
                .build();

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

