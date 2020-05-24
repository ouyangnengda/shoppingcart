package com.zimingsir.cart.dao;

import com.zimingsir.cart.pojo.vo.AttributeVO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月07日 16:56:00
 **/
@Repository
public  interface AttributeDAO {
    List<AttributeVO> get(List<Integer> skus);

    List<AttributeVO> getByCommodity(Integer commodityId);
}
