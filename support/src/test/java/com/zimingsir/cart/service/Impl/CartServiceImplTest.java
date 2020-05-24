package com.zimingsir.cart.service.Impl;

import com.zimingsir.cart.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
class CartServiceImplTest {

    @Autowired
    CartService cartService;

    @Before
    public void before() {
        log.info("================================ 开始测试 \"================================");
    }

    @After
    public void after() {
        log.info("================================ 结束测试 \"================================");
    }

    @Test
    void add() {
    }

    @Test
    void select() {
        Assert.assertEquals(2, cartService.select(1).size());
        // Assert.assertEquals(1, cartService.select(2).size());
    }

    @Test
    void delete() {
    }
}