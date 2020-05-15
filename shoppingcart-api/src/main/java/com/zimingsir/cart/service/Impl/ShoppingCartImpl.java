package com.zimingsir.cart.service.Impl;

import com.sun.xml.internal.bind.v2.TODO;
import com.zimingsir.cart.dao.CartDAO;
import com.zimingsir.cart.dao.SkuDAO;
import com.zimingsir.cart.pojo.entity.Cart;
import com.zimingsir.cart.service.ShoppingCart;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 购物车CRUD操作的实现
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 13:29:00
 **/
@Service
public class ShoppingCartImpl implements ShoppingCart {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    SkuDAO skuDAO;

    @Override
    public List<Integer> insert(Integer userId, List<Integer> skuIds) {
        List<Integer> result = new ArrayList<>(skuIds.size());
        if (userId != null && userId > 0 && skuIds != null && skuIds.size() > 0) {

        }
        return null;
    }

    private Integer insertSku(Integer userId, Integer skuId) {
        Integer id = cartDAO.getId(userId, skuId);
        if (id != null && id > 0) {
            cartDAO.addNumber(id);
        } else {
            // cart 表中插入一条记录
            Cart cart = buildCart(userId, skuId);
            // TODO
            cartDAO.
        }
        return 0;
    }

    private Cart buildCart(Integer userId, Integer skuId) {
        Cart cart = new Cart();
        Integer commodityId = skuDAO.getCommodityId(skuId);
        cart.setUserId(userId)
                .setCommodityId(commodityId)
                .setSkuId(skuId)
                .setNumber(1)
                .setCreateBy(userId)
                .setCreateTime(LocalDateTime.now());
        return cart;
    }
}
