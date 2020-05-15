package com.zimingsir.cart.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class SkuDAOTest {

    @Autowired
    SkuDAO skuDAO;

    @Test
    public void getSkuIdBySelectIndex() {
        String selectIndex = "1_4_7_8";
        log.info(skuDAO.getSkuIdBySelectIndex(selectIndex).toString());
    }


}