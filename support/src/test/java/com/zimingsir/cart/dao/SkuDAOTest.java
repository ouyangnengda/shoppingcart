package com.zimingsir.cart.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@SpringBootTest
@Slf4j
@Transactional
class SkuDAOTest {

    @Autowired
    SkuDAO skuDAO;

    @Test
    public void getSkuIdBySelectIndex() {
        String selectIndex = "1_4_7_8";
        Assert.isTrue(skuDAO.getId(selectIndex) == 2, "查询sku1478id不等于2");
    }

    @Test
    public void getIdByCommodityId() {
        Assert.notEmpty(skuDAO.getIdByCommodityId(1).toArray(),"获取1号商品的sku列表失败");
    }


}