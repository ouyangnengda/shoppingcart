package com.zimingsir.cart.pojo.entity;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月15日 17:04:00
 **/
@Data
@Accessors(chain = true)
public class Cart {
    private Integer id;
    private Integer userId;
    private Integer skuId;
    private Integer number;
    private Integer revision;
    private Integer createBy;
    private LocalDateTime createTime;
    private Integer updateBy;
    private LocalDateTime updateTime;
    private Integer isEffective;
}
