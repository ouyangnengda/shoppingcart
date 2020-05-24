package com.zimingsir.cart.service.Impl;

import com.zimingsir.cart.dao.SkuDAO;
import com.zimingsir.cart.dao.UserDAO;
import com.zimingsir.cart.dubbo.ShoppingCartApi;
import com.zimingsir.cart.pojo.dto.CartDTO;
import com.zimingsir.cart.pojo.entity.Sku;
import com.zimingsir.cart.pojo.entity.User;
import com.zimingsir.cart.pojo.vo.ShopVO;
import com.zimingsir.cart.service.CartService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月18日 10:35:00
 **/
@Service
@Slf4j
public class CartServiceImpl implements CartService {

    private final SkuDAO skuDAO;

    @Reference
    private ShoppingCartApi cartApi;

    public CartServiceImpl(SkuDAO skuDAO) {
        this.skuDAO = skuDAO;
    }

    @Autowired
    UserDAO userDAO;

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
        List<CartDTO> failResult = new ArrayList<>();

        if (!existUser(userId)) {
            return false;
        }

        List<CartDTO> cartDTO = build(selectAndNumber);
        if (cartDTO == null) {
            failResult = cartDTO;
            return false;
        }

        failResult = add(userId, cartDTO);
        if (failResult.isEmpty()) {
            return true;
        }
        // 处理插入失败的sku
        solveFailSku(failResult);
        return false;
    }

    private List<CartDTO> build(String selectAndNumber) {

        String regex = ":";
        String[] afterSplit = selectAndNumber.split(regex);
        String selectIndex = afterSplit[0];
        log.info(selectIndex);
        Integer skuId = skuDAO.getId(selectIndex);
        if (skuId == null || skuId <= 0) {
            return null;
        }
        Integer number = Integer.valueOf(afterSplit[1]);
        log.info(number.toString());

        return buildList(new CartDTO(skuId, number));
    }


    private List<CartDTO> buildList(CartDTO cartDTO) {
        ArrayList<CartDTO> cartDTOS = new ArrayList<>();
        cartDTOS.add(cartDTO);
        return cartDTOS;
    }

    private void solveFailSku(List<CartDTO> failResult) {

    }

    private List<CartDTO> add(Integer userId, List<CartDTO> carts) {

        return cartApi.insert(userId, carts);
    }

    /**
     * @param userId
     * @Method：select
     * @Description: 获取该用户的购物车
     * @return: java.util.List<com.zimingsir.cart.pojo.vo.ShopVO>
     * @Date: 2020/5/18 14:54
     */
    @Override
    public List<ShopVO> select(Integer userId) {
        if (existUser(userId)) {
            return cartApi.select(userId);
        }
        return null;
    }

    private boolean existUser(Integer userId) {
        if (userId == null || userId < 1) {
            return false;
        }
        User user = userDAO.get(userId);
        return user != null;
    }

    /**
     * @param userId
     * @param skuId
     * @param number
     * @Method：delete
     * @Description:
     * @return: boolean
     * @Date: 2020/5/18 15:46
     */
    @Override
    public boolean delete(Integer userId, Integer skuId, Integer number) {
        if (existUser(userId)) {
            List<CartDTO> failResult = cartApi.delete(userId, build(skuId, number));
            if (failResult.isEmpty()) {
                return true;
            } else {
                solveFailSku(failResult);
            }
        }
        return false;

    }

    @Override
    public boolean add(Integer userId, Integer skuId, Integer number) {
        if (existUser(userId)) {
            List<CartDTO> failResult = cartApi.insert(userId, build(skuId, number));
            if (failResult.isEmpty()) {
                return true;
            } else {
                solveFailSku(failResult);
            }
        }
        return false;
    }

    private List<CartDTO> build(Integer skuId, Integer number) {

        Sku sku = skuDAO.get(skuId);
        if (sku != null) {
            CartDTO cartDTO = new CartDTO(skuId, number);
            return buildList(cartDTO);
        }
        return null;
    }
}
