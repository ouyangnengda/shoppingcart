package com.zimingsir.support.service;

import com.zimingsir.support.pojo.Commodity;
import java.util.List;

/**
 * @Description: 商品的服务层
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 19:42:00
 **/
public interface CommodityService {
    List<Commodity> getCommodityList();

    Commodity getCommodityById(int id);
}
