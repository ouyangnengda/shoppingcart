package com.zimingsir.cart.dubbo;

import com.zimingsir.cart.pojo.vo.CartVO;
import java.util.List;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月09日 20:45:00
 **/
public interface ShoppingCartApi {
    // Integer delete(Integer userId, List<Integer> skuIds);
    List<Integer> insert(Integer userId, List<Integer> skuIds);
    // String update(Integer userId, String selectIndex);
    CartVO select(Integer userId);
}
