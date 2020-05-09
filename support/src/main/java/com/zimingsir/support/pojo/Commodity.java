package com.zimingsir.support.pojo;

import lombok.Data;

/**
 * @Description: 商品实体
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 19:41:00
 **/
@Data
public class Commodity {
    private Integer id;
    private String name;
    private String imgUrl;
    private String brand;
    private String price;
    private String shopName;
}
