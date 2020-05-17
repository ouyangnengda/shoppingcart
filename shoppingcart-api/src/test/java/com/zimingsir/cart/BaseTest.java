package com.zimingsir.cart;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月16日 08:01:00
 **/
@SpringBootTest
@Slf4j
public class BaseTest {

    @Before
    void before() {
        log.info("-------------- 开始测试 ---------------");
    }

    @After
    void after() {
        log.info("-------------- 结束测试 ---------------");
    }

}
