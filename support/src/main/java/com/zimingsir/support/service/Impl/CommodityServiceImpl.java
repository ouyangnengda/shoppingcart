package com.zimingsir.support.service.Impl;

import com.zimingsir.support.pojo.Commodity;
import com.zimingsir.support.service.CommodityService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 19:45:00
 **/
@Service
public class CommodityServiceImpl implements CommodityService {

    @Override
    public List<Commodity> getCommodityList() {
        return null;
    }

    @Override
    public Commodity getCommodityById(int id) {
        if (id > 0) {
            //通过dao获得商品对象，如果对象不为null,返回这个对象
        }
        return null;
    }
}
