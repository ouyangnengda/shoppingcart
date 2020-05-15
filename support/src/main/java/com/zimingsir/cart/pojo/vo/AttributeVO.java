package com.zimingsir.cart.pojo.vo;

import java.util.List;
import lombok.Data;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月15日 14:38:00
 **/
@Data
public class AttributeVO {
    private String attributeName;
    List<Value> values;
}
