package com.twuc.shopping.api;

import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

  @Autowired
  private final GoodsRepository goodsRepository;

  public GoodsController(GoodsRepository goodsRepository) {
	this.goodsRepository = goodsRepository;
  }
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

  @PostMapping("/user/goodsAddDto")
  public void registEntityUser(@Valid @RequestBody GoodsDto goods) {
	GoodsDto goodsDto = GoodsDto.builder()
			.name(goods.getName())
			.price(goods.getPrice())
			.units(goods.getUnits())
			.goodsNumber(goods.getGoodsNumber())
			.url(goods.getUrl())
			.build();
	goodsRepository.save(goodsDto);
  }

}
