package com.zimingsir.cart.dao.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月15日 16:06:00
 **/
@Data
public class CartVO implements Serializable {
    List<ShopVO> shopVOs;
}
