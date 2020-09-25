package com.twuc.shopping.repository;

import com.twuc.shopping.dto.GoodsDto;
import org.springframework.data.repository.CrudRepository;

public interface GoodsRepository extends CrudRepository<GoodsDto, Integer> {
}
