package com.zimingsir.support.dao;

import com.zimingsir.support.pojo.Attribute;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月07日 16:56:00
 **/
@Repository
public interface AttributeDAO {
    List<Attribute> getAttributeByCommodityId(Integer id);
}
