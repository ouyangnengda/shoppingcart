package com.zimingsir.cart.pojo.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月16日 08:50:00
 **/
@Data
public class ShopVO implements Serializable {
    private String shopName;
    List<SkuVO> skuVOs;

}
