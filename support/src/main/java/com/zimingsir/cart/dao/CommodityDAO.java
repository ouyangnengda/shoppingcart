package com.zimingsir.cart.dao;

import com.zimingsir.cart.pojo.vo.CommodityVO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @Description: 商品相关DAO操作
 * @Author: 欧阳能达
 * @Created: 2020年05月08日 09:44:00
 **/
@Repository
public interface CommodityDAO {
    List<CommodityVO> getAllCommodity();
    CommodityVO getCommodityById(Integer id);
}
