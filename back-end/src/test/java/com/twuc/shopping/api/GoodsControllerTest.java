package com.twuc.shopping.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GoodsControllerTest {
  @Autowired
  MockMvc mockMvc;

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

}
