package com.zimingsir.cart.pojo.entity;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月22日 14:58:00
 **/
@Data
public class Sku {
    private Integer id;
    private Double price;
    private Integer stock;
    private String valueIndex;
    private Integer commodityId;
    private Integer createBy;
    private LocalDateTime createTime;
    private Integer updateBy;
    private LocalDateTime updateTime;
}
