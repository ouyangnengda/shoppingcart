package com.zimingsir.support.dao;

import com.zimingsir.support.pojo.Commodity;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class CommodityDAOTest {

    @Autowired
    CommodityDAO commodityDAO;

    @Test
    public void testGetAllCommodity() {
        List<Commodity> commodities = commodityDAO.getAllCommodity();
        for (Commodity c : commodities) {
            log.info(c.toString());
        }
    }

    @Test
    public void getCommodityById() {
        Commodity commodity = commodityDAO.getCommodityById(1);
        log.info(commodity.toString());
    }
}