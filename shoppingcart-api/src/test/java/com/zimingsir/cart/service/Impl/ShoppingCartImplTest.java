package com.zimingsir.cart.service.Impl;

import com.zimingsir.cart.service.ShoppingCart;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
class ShoppingCartImplTest {

    @Autowired
    ShoppingCart shoppingCart;

    @Test
    void insert() {
        List<Integer> skus = new ArrayList<>();
        skus.add(1);
        skus.add(13);
        skus.add(14);
        // List<Integer> fail = shoppingCart.insert(1,skus);
        log.info("++++++++++++++++ shibao +++++++++++++");
        /*for (Integer i : fail) {
            log.info(i.toString());
        }*/
        // Assert.isTrue(.isEmpty());
    }

    @Test
    void select() {
    }
}