package com.twuc.shopping.repository;

import com.twuc.shopping.dto.GoodsDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsRepository extends CrudRepository<GoodsDto, Integer> {
  List<GoodsDto> findAll();
}
