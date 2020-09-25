package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name = "goods")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDto {

  @javax.persistence.Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer Id;
  private String name;
  private float price;
  private String units;
  private int goodsNumber;
  private String url;
}
