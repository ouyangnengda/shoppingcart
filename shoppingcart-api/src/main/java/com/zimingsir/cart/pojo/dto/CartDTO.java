package com.zimingsir.cart.pojo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDTO implements Serializable {
    private Integer skuId;
    private Integer number;
}
