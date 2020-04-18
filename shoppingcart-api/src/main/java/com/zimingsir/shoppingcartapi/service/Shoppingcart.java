package com.zimingsir.shoppingcartapi.service;

import com.zimingsir.shoppingcartapi.pojo.ShoppingcartOperation;

/**
 * @Description: 关于购物侧crud操作
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 13:21:00
 **/
public interface Shoppingcart {
    boolean delete(Integer userId, ShoppingcartOperation so);
    boolean insert(Integer userId, ShoppingcartOperation so);
    boolean update(Integer userId, ShoppingcartOperation so);
    boolean select(Integer userId, ShoppingcartOperation so);

}
