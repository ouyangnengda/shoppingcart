package com.zimingsir.cart.dubbo.impl;

import com.zimingsir.cart.dubbo.ShoppingCartApi;
import com.zimingsir.cart.pojo.dto.CartDTO;
import com.zimingsir.cart.pojo.vo.ShopVO;
import com.zimingsir.cart.service.ShoppingCart;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月09日 20:46:00
 **/
@Service
@Slf4j
public class ShoppingCartApiImpl implements ShoppingCartApi {

    @Autowired
    ShoppingCart cart;

    @Override
    public List<CartDTO> delete(Integer userId, List<CartDTO> skuIds) {
        return cart.delete(userId, skuIds);
    }

    /**
     * @Method：insert
     * @Description: 将所有sku插入到用户的购物车中。插入失败的sku将被返回
     * @param userId
     * @param skuIds
     * @return: java.util.List<java.lang.Integer>
     * @Date: 2020/5/15 20:30
     */
    @Override
    public List<CartDTO> insert(Integer userId, List<CartDTO> skuIds) {
        return cart.insert(userId, skuIds);
    }

    @Override
    public List<ShopVO> select(Integer userId) {
        return cart.select(userId);
    }
}
