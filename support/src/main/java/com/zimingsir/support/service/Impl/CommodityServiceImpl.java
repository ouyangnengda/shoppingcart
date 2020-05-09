package com.zimingsir.support.service.Impl;

import com.zimingsir.support.dao.CommodityDAO;
import com.zimingsir.support.pojo.Commodity;
import com.zimingsir.support.service.CommodityService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 19:45:00
 **/
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityDAO commodityDAO;

    @Override
    public List<Commodity> getCommodityList() {
        return null;
    }

    @Override
    public Commodity getCommodityById(Integer id) {
        if (id != null && id > 0) {
            Optional<Commodity> commodityOption = Optional.ofNullable(commodityDAO.getCommodityById(id));
            if (commodityOption.isPresent()) {
                return commodityOption.get();
            }
        }
        return null;
    }

}
