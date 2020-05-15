package com.zimingsir.cart.dao;

import com.zimingsir.cart.pojo.entity.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月15日 16:22:00
 **/
@Repository
public interface CartDAO {
    void lock(Integer id);

    Integer getId(@Param("userId") Integer userId, @Param("skuId") Integer skuId);

    void incrNumber(@Param("id") Integer id);

    void insert(Cart cart);

    Integer getNumber(Integer skuId);

    void unlock(Integer id, Integer lock);

    Cart get(Integer id);
}

