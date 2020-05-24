package com.zimingsir.cart.service;

import com.zimingsir.cart.pojo.dto.CartDTO;
import com.zimingsir.cart.pojo.vo.ShopVO;
import java.util.List;

/**
 * @Description: 关于购物侧crud操作
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 13:21:00
 **/
public interface ShoppingCart {
    List<CartDTO> insert(Integer userId, List<CartDTO> skus);

    List<ShopVO> select(Integer userId);

    List<CartDTO> delete(Integer userId, List<CartDTO> skus);
}
