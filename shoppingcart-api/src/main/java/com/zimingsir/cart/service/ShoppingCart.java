package com.zimingsir.cart.service;

import java.util.List;

/**
 * @Description: 关于购物侧crud操作
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 13:21:00
 **/
public interface ShoppingCart {
    List<Integer> insert(Integer userId, List<Integer> skuIds);

}
