package com.twuc.shopping.api;

import com.twuc.shopping.domain.Goods;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class GoodsController {

//  @Autowired
//  private final GoodsRepository goodsRepository;
//
//  public GoodsController(GoodsRepository goodsRepository) {
//	this.goodsRepository = goodsRepository;
//  }
  List<Goods> goodsLists = initGoodsList();

  private List<Goods> initGoodsList() {
	List<Goods> goodsTempList = new ArrayList<>();
	goodsTempList.add(new Goods("大米", 2, "斤", 5));
	return goodsTempList;
  }

  @PostMapping("/goods/goodsAdd")
  public void registUser(@Valid @RequestBody Goods goods) {
	goodsLists.add(goods);
  }

}
