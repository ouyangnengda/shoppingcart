package com.zimingsir.cart.dao;

import com.zimingsir.cart.pojo.entity.Cart;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CartDAOTest {

    @Autowired
    CartDAO cartDAO;

    @Test
    void getId() {
        Integer id = cartDAO.getId(1, 1);
        log.info(id.toString());
    }

    @Test
    void addNumber() {
        log.info(cartDAO.getId(1, 1).toString());
    }

    @Test
    void insert() {
        Cart cart = buildCart(11, 22);
        cartDAO.insert(cart);
    }

    private Cart buildCart(Integer userId, Integer skuId) {
        Cart cart = new Cart();
        cart.setUserId(userId).setCommodityId(32).setSkuId(skuId).setNumber(1).setCreateBy(userId).setCreateTime(LocalDateTime.now());
        return cart;
    }

    @Test
    void lock() {
        log.info(cartDAO.lock(2).toString());
        log.info(cartDAO.get(2).toString());
        log.info(cartDAO.lock(2).toString());
        log.info(cartDAO.get(2).toString());
        log.info(cartDAO.unlock(2, 1).toString());
        log.info(cartDAO.get(2).toString());

    }
}