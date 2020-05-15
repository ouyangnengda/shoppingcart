package com.zimingsir.cart.dubbo.impl;

import com.zimingsir.cart.dubbo.ShoppingCartApi;
import com.zimingsir.cart.service.ShoppingCart;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月09日 20:46:00
 **/
@Service
public class ShoppingCartApiImpl implements ShoppingCartApi {
    @Autowired
    ShoppingCart cart;

    @Override
    public String delete(Integer userId, String selectIndex) {
        return cart.delete(userId, selectIndex);
    }

    @Override
    public String insert(Integer userId, String selectIndex) {

        return cart.insert(userId, selectIndex);
    }

    @Override
    public String update(Integer userId, String selectIndex) {

        return cart.update(userId, selectIndex);
    }

    @Override
    public String select(Integer userId, String selectIndex) {

        return cart.select(userId, selectIndex);
    }
}
