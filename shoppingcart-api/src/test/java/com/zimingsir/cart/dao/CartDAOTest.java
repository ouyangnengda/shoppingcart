package com.zimingsir.cart.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CartDAOTest {

    @Autowired
    CartDAO cartDAO;

    @Test
    void getId() {
        Integer id = cartDAO.getId(1,1);
        log.info(id.toString());
    }

    @Test
    void addNumber() {
        log.info(cartDAO.getId(1,1).toString());
        log.info(cartDAO.addNumber(1).toString());
    }
}