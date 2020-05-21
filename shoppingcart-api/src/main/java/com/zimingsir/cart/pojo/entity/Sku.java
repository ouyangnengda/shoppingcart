package com.zimingsir.cart.pojo.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月21日 20:31:00
 **/
@Data
@AllArgsConstructor
public class Sku {
    private Integer id;
    private Double price;
    private Integer stock;
    private String value_index;
    private Integer commodityId;
    private Short revision;
    private Integer createBy;
    private LocalDateTime creatTime;
    private Integer updateBy;
    private LocalDateTime updateTime;
}
