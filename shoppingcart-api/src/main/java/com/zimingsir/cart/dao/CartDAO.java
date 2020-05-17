package com.zimingsir.cart.dao;

import com.zimingsir.cart.pojo.entity.Cart;
import com.zimingsir.cart.pojo.vo.ShopVO;
import java.util.List;
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

    List<ShopVO> getByUserId(Integer userID);

    List<String> getValue(String attributeIndex);
}

