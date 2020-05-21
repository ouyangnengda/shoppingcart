package com.zimingsir.cart.dubbo;

import com.zimingsir.cart.pojo.vo.ShopVO;
import com.zimingsir.cart.pojo.dto.CartDTO;
import java.util.List;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月09日 20:45:00
 **/
public interface ShoppingCartApi {
    List<CartDTO> insert(Integer userId, List<CartDTO> carts);

    List<ShopVO> select(Integer userId);

    List<CartDTO> delete(Integer userId, List<CartDTO> carts);
}
