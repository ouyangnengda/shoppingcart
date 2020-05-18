package com.zimingsir.cart.service.Impl;

import com.zimingsir.cart.dao.SkuDAO;
import com.zimingsir.cart.dao.vo.ShopVO;
import com.zimingsir.cart.dubbo.ShoppingCartApi;
import com.zimingsir.cart.pojo.dto.CartDTO;
import com.zimingsir.cart.service.CartService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月18日 10:35:00
 **/
@Service
public class CartServiceImpl implements CartService {

    private final SkuDAO skuDAO;

    @Reference
    private ShoppingCartApi cartApi;

    public CartServiceImpl(SkuDAO skuDAO) {
        this.skuDAO = skuDAO;
    }

    /**
     * @param userId
     * @param selectAndNumber
     * @Method：add
     * @Description: 将selectAndNumber包装为一个CartDTO，然后插入CartDTO
     * @return: boolean
     * @Date: 2020/5/18 14:51
     */
    @Override
    public boolean add(Integer userId, String selectAndNumber) {

        CartDTO cartDTO = transfer(selectAndNumber);
        if (cartDTO == null) {
            return false;
        }

        List<CartDTO> failResult = add(userId, buildList(cartDTO));
        if (failResult != null && failResult.isEmpty()) {
            return true;
        }
        // 处理插入失败的sku
        solveFailSkus(failResult);
        return false;
    }

    private CartDTO transfer(String selectAndNumber) {

        String regex = ":";
        String[] afterSplit = selectAndNumber.split(regex);
        String selectIndex = afterSplit[1];
        Integer skuId = skuDAO.getId(selectIndex);
        if (skuId == null || skuId <= 0) {
            return null;
        }
        Integer number = Integer.valueOf(afterSplit[2]);
        return new CartDTO(skuId, number);
    }

    private List<CartDTO> buildList(CartDTO cartDTO) {
        ArrayList<CartDTO> cartDTOS = new ArrayList<>();
        cartDTOS.add(cartDTO);
        return cartDTOS;
    }

    private void solveFailSkus(List<CartDTO> failResult) {

    }

    private List<CartDTO> add(Integer userId, List<CartDTO> carts) {

        return cartApi.insert(userId, carts);
    }

    /**
     * @param userId
     * @Method：select
     * @Description: 获取该用户的购物车
     * @return: java.util.List<com.zimingsir.cart.dao.vo.ShopVO>
     * @Date: 2020/5/18 14:54
     */
    @Override
    public List<ShopVO> select(Integer userId) {

        Optional<Integer> userIdOp = Optional.ofNullable(userId);
        if (userIdOp.isPresent()) {
            return cartApi.select(userId);
        }
        return null;
    }

    /**
     * @Method：delete
     * @Description:
     * @param userId
     * @param skuId
     * @param number
     * @return: boolean
     * @Date: 2020/5/18 15:46
     */
    @Override
    public boolean delete(Integer userId, Integer skuId, Integer number) {

        CartDTO cartDTO = new CartDTO(skuId, number);
        List<CartDTO> failResult = cartApi.delete(userId, buildList(cartDTO));
        if (failResult.isEmpty()) {
            return true;
        }
        solveFailSkus(failResult);
        return false;
    }
}
