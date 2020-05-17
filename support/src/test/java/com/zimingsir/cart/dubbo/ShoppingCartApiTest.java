package com.zimingsir.cart.dubbo;

import java.util.ArrayList;
import java.util.List;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShoppingCartApiTest {

    @Reference
    private ShoppingCartApi cartApi;

    @Test
    void insert() {
        List<Integer> sku = new ArrayList<>();
        sku.add(3);
        Assert.isEmpty(cartApi.insert(1, sku));
    }

}