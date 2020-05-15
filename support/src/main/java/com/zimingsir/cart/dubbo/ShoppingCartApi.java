package com.zimingsir.cart.dubbo;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月09日 20:45:00
 **/
public interface ShoppingCartApi {
    String delete(Integer userId, String selectIndex);
    String insert(Integer userId, String selectIndex);
    String update(Integer userId, String selectIndex);
    String select(Integer userId, String selectIndex);
}
