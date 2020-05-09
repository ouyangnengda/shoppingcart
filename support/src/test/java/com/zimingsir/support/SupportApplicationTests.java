package com.zimingsir.support;

import com.zimingsir.support.dao.AttributeDAO;
import com.zimingsir.support.pojo.Attribute;
import com.zimingsir.support.pojo.Value;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SupportApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    AttributeDAO attributeDAO;

    @Test
    void testSkuDetail() {
        List<Attribute> list = attributeDAO.getAttributeByCommodityId(1);
        for (Attribute l : list) {
            System.out.println(l.getAttributeName());
            for (Value d : l.getValues()) {
                System.out.println(d.toString());
            }
        }
    }

}
