package com.zimingsir.cart.dao;

import com.zimingsir.cart.pojo.vo.AttributeVO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
class AttributeDAOTest {

    @Autowired
    AttributeDAO attributeDAO;

    @Test
    public void getAttributeByCommodityId() {

        List<AttributeVO> attributeVOS = attributeDAO.getByCommodity(2);
        Assert.isTrue(attributeVOS.size() == 2);
    }
}