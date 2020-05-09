package com.zimingsir.support.service.Impl;

import com.zimingsir.support.pojo.Commodity;
import com.zimingsir.support.service.LocalCartService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年04月19日 09:24:00
 **/
@Service
public class LocalCartServiceImpl implements LocalCartService {

    @Override
    public List<Commodity> add(List<Commodity> commodities, Commodity commodity) {
        // TODO 本地购物车的添加商品服务
        return null;
    }
}
