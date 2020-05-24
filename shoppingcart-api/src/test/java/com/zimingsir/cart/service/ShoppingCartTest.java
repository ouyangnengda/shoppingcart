package com.zimingsir.cart.service;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class ShoppingCartTest {

    @Autowired
    ShoppingCart shoppingCart;

    @Test
    void insert() {
        /*List<Integer> empty = new ArrayList<>();
        Assert.isNull(shoppingCart.insert(10086, empty), "插入一个userId=10086，sku为empty的对象失败");

        List<Integer> empty2 = new ArrayList<>();
        empty2.add(2);
        Assert.isNull(shoppingCart.insert(0, empty2), "插入一个userId=0，skuId=2");

        List<Integer> empty3 = new ArrayList<>();
        empty3.add(100);
        Assert.notNull(shoppingCart.insert(1, empty3), "插入一个userId=1，skuId=100");

        List<Integer> empty4 = new ArrayList<>();
        empty4.add(3);
        Assert.notNull(shoppingCart.insert(1, empty4), "插入一个userId=1，skuId=3");*/

    }

    @Test
    void select() {
        // CartVO cartVO = shoppingCart.select(1);
        // Assert.notNull(cartVO);
        // log.info(cartVO.toString());

    }
}