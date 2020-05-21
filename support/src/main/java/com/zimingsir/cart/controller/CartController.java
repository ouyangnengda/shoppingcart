package com.zimingsir.cart.controller;

import com.zimingsir.cart.dubbo.ShoppingCartApi;
import com.zimingsir.cart.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private ShoppingCartApi cart;

    @Autowired
    CartService cartService;

    /**
     * @param model
     * @param userId
     * @param selectAndNumber
     * @Method：add
     * @Description: 收到的selectIndex的格式为：1_3_5_8:2 ，使用冒号分割selectIndex和number
     * @return: java.lang.String
     * @Date: 2020/5/18 10:59
     */
    @RequestMapping("/add")
    public String add(Model model, @RequestParam("userId") Integer userId, @RequestParam("selectAndNumber") String selectAndNumber) {
        boolean success = cartService.add(userId, selectAndNumber);
        if (success) {
            return "success";
        }
        return "fail";
    }

    /**
     * @param userId
     * @param skuId
     * @param number
     * @Method：delete
     * @Description: 删除一个商品
     * @return: java.lang.String
     * @Date: 2020/5/18 15:18
     */
    /*@PostMapping("/delete")
    public String delete(Model model, @RequestParam("userId") Integer userId, @RequestParam("skuId") Integer skuId, @RequestParam("number") Integer number) {

        boolean success = cartService.delete(userId, skuId, number);
        if (success) {
            List<ShopVO> shops = cartService.select(userId);
            model.addAttribute("shops", shops);
            return "cart";
        }
        // TODO 返回一个失败的页面
    }

    @PostMapping("/increase")
    public String increase(Model model, @RequestBody List<CartDTO> cartDTOS) {

    }

    @PostMapping("/decrease")
    public String increase(Model model, @RequestBody List<CartDTO> cartDTOS) {

    }*/
}
















