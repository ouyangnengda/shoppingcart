package com.zimingsir.cart.pojo.vo;

import java.util.List;
import lombok.Data;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月15日 14:37:00
 **/
@Data
public class CommodityVO {
    private Integer id;
    private String name;
    private String imgUrl;
    private String brand;
    private Double price;
    private String shopName;
    List<AttributeVO> attributes;
}
