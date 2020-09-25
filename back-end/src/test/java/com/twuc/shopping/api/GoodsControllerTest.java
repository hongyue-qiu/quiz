package com.twuc.shopping.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.repository.GoodsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GoodsControllerTest {
  @Autowired
  MockMvc mockMvc;
  @Autowired
  GoodsRepository goodsRepository;

  @BeforeEach
  void setUp() {
    goodsRepository.deleteAll();
  }

  @Test
  public void should_get_goods_ist() throws Exception {
    GoodsDto goodsDto = GoodsDto.builder()
            .name("哇哈哈")
            .price(5)
            .units("瓶")
            .goodsNumber(10)
            .url("aaa/")
            .build();
    GoodsDto save = goodsRepository.save(goodsDto);


    mockMvc
            .perform(get("/order"))
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", is("哇哈哈")))
            .andExpect(jsonPath("$[0].units", is("瓶")))
            .andExpect(status().isOk());
  }

  @Test
  void goods_dto_register() throws Exception {
    Goods goods = new Goods("哇哈哈",5,"瓶",3);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(goods);

    mockMvc.perform(post("/order")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

    List<GoodsDto> goodss = goodsRepository.findAll();
    assertEquals(1, goodss.size());
    assertEquals("哇哈哈", goodss.get(0).getName());


  }
  @Test
  void goods_can_add() throws Exception {
    Goods goods = new Goods("哇哈哈",5,"瓶",3);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(goods);

    mockMvc.perform(post("/goods/goodsAdd")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

  }
  @Test
  void goods_name_not_empty() throws Exception {
    Goods goods = new Goods("",5,"瓶",3);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(goods);

    mockMvc.perform(post("/goods/goodsAdd")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());

  }
  @Test
  void goods_price_not_less_0() throws Exception {
    Goods goods = new Goods("哇哈哈",-5,"瓶",3);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(goods);

    mockMvc.perform(post("/goods/goodsAdd")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());

  }
  @Test
  void goods_units_not_less_0() throws Exception {
    Goods goods = new Goods("哇哈哈",5,null,3);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(goods);

    mockMvc.perform(post("/goods/goodsAdd")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());

  }

}
