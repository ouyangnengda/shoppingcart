package com.zimingsir.cart.dubbo;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
class ShoppingCartApiTest {

    @Reference
    private ShoppingCartApi cartApi;

    @Test
    void insert() {
        List<Integer> sku = new ArrayList<>();
        sku.add(3);
        // Assert.isEmpty(cartApi.insert(1, sku));
    }

    @Test
    void select() {
        // 正常情况，用户1的购物车店铺只有两个
        Assert.assertEquals("用户1的购物车店铺数量等于2", 2, cartApi.select(1).size());


        // 用户不存在
        Assert.assertEquals("查询一个不存在的用户的购物车", 0, cartApi.select(50).size());
    }

}