package com.zimingsir.cart.controller;

import com.zimingsir.cart.dao.SkuDAO;
import com.zimingsir.cart.dubbo.ShoppingCartApi;
import com.zimingsir.cart.pojo.vo.CartVO;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月15日 15:34:00
 **/
@Controller
@RequestMapping("/cart")
@Slf4j
public class CartController {

    @Reference
    ShoppingCartApi cart;

    @Autowired
    SkuDAO skuDAO;

    @PostMapping("/add")
    public String add(Model model, @RequestParam("userId") Integer userId, @RequestParam("selectIndex") String selectIndex) {
        List<Integer> skuIds = new ArrayList<>();
        if (selectIndex != null) {
            Integer skuId = skuDAO.getSkuIdBySelectIndex(selectIndex);
            if (skuId != null && userId != null && userId > 0) {
                skuIds.add(skuId);
                List<Integer> result = cart.insert(userId, skuIds);
                if (result != null) {
                    if (result.size() == 0) {
                        CartVO cartVO = cart.select(userId);
                        if (cartVO != null) {
                            model.addAttribute("cartVO", cartVO);
                            return "cart";
                        }
                    } else {
                        // TODO 插入失败的skuId怎么处理
                    }
                }

            }
        }
        return null;
    }
}
