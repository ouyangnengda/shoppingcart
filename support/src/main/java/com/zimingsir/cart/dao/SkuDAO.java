package com.zimingsir.cart.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月15日 15:49:00
 **/
@Repository
public interface SkuDAO {
    Integer getId(String selectIndex);

    List<Integer> getIdByCommodityId(Integer commodityId);
}
