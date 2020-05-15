package com.zimingsir.cart.service.Impl;

import com.zimingsir.cart.service.ShoppingCart;
import org.springframework.stereotype.Service;

/**
 * @Description: 购物车CRUD操作的实现
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 13:29:00
 **/
@Service
public class ShoppingCartImpl implements ShoppingCart {

    public String combin(String operation, String userId, String selectIndex) {
        return operation + ":{" + userId + "+" + selectIndex + "}";
    }


    @Override
    public String delete(Integer userId, String selectIndex) {
        return combin("delete", userId.toString(), selectIndex);

    }

    @Override
    public String insert(Integer userId, String selectIndex) {
        return combin("insert", userId.toString(), selectIndex);

    }

    @Override
    public String update(Integer userId, String selectIndex) {
        return combin("update", userId.toString(), selectIndex);
    }

    @Override
    public String select(Integer userId, String selectIndex) {
        return combin("select", userId.toString(), selectIndex);
    }
}
