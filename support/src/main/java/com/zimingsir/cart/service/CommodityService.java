package com.zimingsir.cart.service;

import com.zimingsir.cart.pojo.vo.CommodityVO;
import java.util.List;

/**
 * @Description: 商品的服务层
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 19:42:00
 **/
public interface CommodityService {
    List<CommodityVO> getCommodityList();

    CommodityVO getCommodityById(Integer id);
}
