package com.twuc.shopping.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
  @NotEmpty
  String name;
  @Min(0)
  float price;
  @NotEmpty
  String units;
  int goodsNumber;
}
