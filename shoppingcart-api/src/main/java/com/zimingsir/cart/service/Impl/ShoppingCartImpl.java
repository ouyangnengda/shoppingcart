package com.zimingsir.cart.service.Impl;

import com.zimingsir.cart.dao.CartDAO;
import com.zimingsir.cart.dao.SkuDAO;
import com.zimingsir.cart.pojo.dto.CartDTO;
import com.zimingsir.cart.pojo.entity.Cart;
import com.zimingsir.cart.pojo.vo.CartVO;
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
    public List<CartDTO> insert(Integer userId, List<CartDTO> skuIds) {
        List<CartDTO> failResult = new ArrayList<>(skuIds.size());
        if (userId != null && userId > 0 && skuIds.size() > 0) {
            for (CartDTO sku : skuIds) {
                boolean success = insertSku(userId, sku);
                if (!success) {
                    failResult.add(sku);
                }
            }
            return failResult;
        }
        return null;
    }

    @Override
    public CartVO select(Integer userId) {
        if (userId == null || userId < 1) {
            return null;
        }
        // Optional<CartVO> cartVO = Optional.ofNullable(cartDAO.getByUserId(userId));
        // if (!cartVO.isPresent()) {
        //     return cartVO.get();
        // }
        return null;
    }

    /**
     * @param userId
     * @param sku
     * @Method：insertSku
     * @Description: 如果记录已存在，那就增加该商品数量；如果不存在，那就插入。
     * @return: java.lang.Integer
     * @Date: 2020/5/15 20:22
     */
    private boolean insertSku(Integer userId, CartDTO sku) {

        Integer id = cartDAO.getId(userId, sku.getSkuId());
        // 原记录不存在
        if (id == null) {
            Cart cart = buildCart(userId, sku.getSkuId(), sku.getNumber());
            if (cart == null) {
                return false;
            }
            cartDAO.insert(cart);
            // 插入成功
            if (cart.getNumber().equals(cartDAO.getNumber(cart.getUserId(),cart.getSkuId()))) {
                return true;
            }
            // 原记录存在，那就增加增加该记录的数量
        } else {
            // TODO 乐观锁不会用
            // Integer lock = cartDAO.lock(sku);
            // if (lock > 0) {
            //     cartDAO.incrNumber(id);
            //     cartDAO.unlock(id, lock);
            //     return 1;
            // }
            Integer stock = skuDAO.get(sku.getSkuId()).getStock();
            if (stock > sku.getNumber()) {
                cartDAO.incrNumber(id, sku.getNumber());
                return true;
            }
        }
        return false;
    }

    private Cart buildCart(Integer userId, Integer skuId, Integer number) {
        Cart cart = new Cart();
        Integer commodityId = skuDAO.getCommodityId(skuId);
        if (commodityId == null) {
            return null;
        }
        cart.setUserId(userId).setSkuId(skuId).setNumber(number).setCreateBy(userId).setCreateTime(LocalDateTime.now());
        return cart;
    }

}