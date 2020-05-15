package com.zimingsir.cart.dubbo.impl;

import com.zimingsir.cart.dubbo.ShoppingCartApi;
import com.zimingsir.cart.pojo.vo.CartVO;
import com.zimingsir.cart.service.ShoppingCart;
import java.util.List;
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
    public Integer delete(Integer userId, List<Integer> skuIds) {
        return null;
    }

    @Override
    public List<Integer> insert(Integer userId, List<Integer> skuIds) {
        return cart.insert(userId, skuIds);
    }

    @Override
    public CartVO select(Integer userId) {
        return null;
    }
}