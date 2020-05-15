package com.zimingsir.cart.service.Impl;

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

    /**
     * @param userId
     * @param skuIds
     * @Method：insert
     * @Description: 向数据库中插入一组sku
     * @return: java.util.List<java.lang.Integer>
     * @Date: 2020/5/15 20:33
     */
    @Override
    public List<Integer> insert(Integer userId, List<Integer> skuIds) {
        List<Integer> failResult = new ArrayList<>(skuIds.size());
        if (userId != null && userId > 0 && skuIds.size() > 0) {
            for (Integer skuId : skuIds) {
                Integer result = insertSku(userId, skuId);
                if (result == 0) {
                    failResult.add(skuId);
                }
            }
            return failResult;
        }
        return null;
    }

    /**
     * @param userId
     * @param skuId
     * @Method：insertSku
     * @Description: 向数据库中插入一条sku
     * @return: java.lang.Integer
     * @Date: 2020/5/15 20:22
     */
    private Integer insertSku(Integer userId, Integer skuId) {
        Integer id = cartDAO.getId(userId, skuId);
        if (id == null) {
            Cart cart = buildCart(userId, skuId);
            cartDAO.insert(cart);
            // 插入成功
            if (cart.getNumber().equals(cartDAO.getNumber(cart.getSkuId()))) {
                return 1;
            }
        } else {
            Integer lock = cartDAO.lock(skuId);
            if (lock > 0) {
                cartDAO.incrNumber(id);
                cartDAO.unlock(id, lock);
                return 1;
            }

        }
        return 0;
    }

    private Cart buildCart(Integer userId, Integer skuId) {
        Cart cart = new Cart();
        Integer commodityId = skuDAO.getCommodityId(skuId);
        cart.setUserId(userId).setCommodityId(commodityId).setSkuId(skuId).setNumber(1).setCreateBy(userId).setCreateTime(LocalDateTime.now());
        return cart;
    }
}
