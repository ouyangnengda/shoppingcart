package com.zimingsir.support.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class ShoppingCartApiTest {

    @Reference
    private ShoppingCartApi shoppingCartApi;

    @Test
    public void delete() {
        log.info(shoppingCartApi.delete(1, "1_3_5"));
    }

}