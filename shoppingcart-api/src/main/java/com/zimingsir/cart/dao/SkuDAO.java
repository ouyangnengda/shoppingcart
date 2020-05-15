package com.zimingsir.cart.dao;

import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月15日 17:13:00
 **/
@Repository
public interface SkuDAO {
    Integer getCommodityId(Integer skuId);
}
