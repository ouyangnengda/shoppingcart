package com.zimingsir.support.service;

import com.zimingsir.support.pojo.Commodity;
import java.util.List;

/**
 * @Description: 本地购物车服务
 * @Author: 欧阳能达
 * @Created: 2020年04月19日 09:19:00
 **/
public interface LocalCartService {
    List<Commodity> add(List<Commodity> commodities, Commodity commodity);
}
