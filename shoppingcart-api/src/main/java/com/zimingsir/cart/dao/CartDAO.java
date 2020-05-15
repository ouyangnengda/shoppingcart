package com.zimingsir.cart.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月15日 16:22:00
 **/
@Repository
public interface CartDAO {
    Integer getId(@Param("userId") Integer userId, @Param("skuId") Integer skuId);
    Integer addNumber(@Param("id")Integer id);
}
