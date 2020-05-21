package com.zimingsir.cart.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
class CartServiceTest {

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
    public void add() {
        // 完全正常情况====应该返回true
        Assert.isTrue(cartService.add(1, "1_4_7_8:2"),"完全正常情况");

        // userId 不存在， sku存在====应该返回false
        Assert.isTrue(!cartService.add(1000, "1_4_7_8:2"),"userId 不存在， sku存在");

        // userId 存在， sku不存在====应该返回false
        Assert.isTrue(!cartService.add(1, "1_4_7_1000:2"), "userId 存在， sku不存在");

        // userId 存在，sku存在，但是数量没有这么多====应该返回false
        Assert.isTrue(!cartService.add(1, "1_4_7_8:1000"),"userId 存在，sku存在，但是数量没有这么多");

    }

}