package com.zimingsir.cart.service;

/**
 * @Description: 关于购物侧crud操作
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 13:21:00
 **/
public interface ShoppingCart {
    String delete(Integer userId, String selectIndex);
    String insert(Integer userId, String selectIndex);
    String update(Integer userId, String selectIndex);
    String select(Integer userId, String selectIndex);

}
