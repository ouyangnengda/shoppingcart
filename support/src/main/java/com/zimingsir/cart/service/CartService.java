package com.zimingsir.cart.service;

import com.zimingsir.cart.pojo.vo.ShopVO;
import java.util.List;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月18日 10:33:00
 **/
public interface CartService {

    boolean add(Integer userId, String selectAndNumber);

    List<ShopVO> select(Integer userId);

    boolean delete(Integer userId, Integer skuId, Integer number);

    boolean add(Integer userId, Integer skuId, Integer number);
}
