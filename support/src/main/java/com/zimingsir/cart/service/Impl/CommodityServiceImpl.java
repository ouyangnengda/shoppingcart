package com.zimingsir.cart.service.Impl;

import com.zimingsir.cart.dao.CommodityDAO;
import com.zimingsir.cart.pojo.vo.CommodityVO;
import com.zimingsir.cart.service.CommodityService;
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
    public List<CommodityVO> getCommodityList() {
        return null;
    }

    @Override
    public CommodityVO getCommodityById(Integer id) {
        if (id != null && id > 0) {
            Optional<CommodityVO> commodityOption = Optional.ofNullable(commodityDAO.getCommodityById(id));
            if (commodityOption.isPresent()) {
                return commodityOption.get();
            }
        }
        return null;
    }

}
