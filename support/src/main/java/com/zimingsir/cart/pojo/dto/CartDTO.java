package com.zimingsir.cart.pojo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月18日 10:57:00
 **/
@Data
@AllArgsConstructor
public class CartDTO implements Serializable {
    private Integer skuId;
    private Integer number;

}
