package com.zimingsir.cart.pojo.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月16日 08:55:00
 **/
@Data
class SkuVO implements Serializable {
    private Integer id;
    private String imgUrl;
    private String commodityName;
    private String price;
    private String number;
    // 需要去拼装value的名称
    private List<String> values;
}
