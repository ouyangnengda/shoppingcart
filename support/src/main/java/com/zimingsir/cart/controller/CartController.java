package com.zimingsir.cart.controller;

import com.zimingsir.cart.pojo.vo.ShopVO;
import com.zimingsir.cart.service.CartService;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月15日 15:34:00
 **/
@Controller
@RequestMapping("/cart")
@Slf4j
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public String get(Model model, @PathVariable("userId") Integer userId) {
        List<ShopVO> shopVOs = cartService.select(userId);
            model.addAttribute("shopVOs", shopVOs);
            return "cart";

    }

    /**
     * @param userId
     * @param selectAndNumber
     * @Method：add
     * @Description: 收到的selectIndex的格式为：1_3_5_8:2 ，使用冒号分割selectIndex和number
     * @return: java.lang.String
     * @Date: 2020/5/18 10:59
     */
    @RequestMapping("/add")
    public String add(@RequestParam("userId") Integer userId, @RequestParam("selectAndNumber") String selectAndNumber) {
        boolean success = cartService.add(userId, selectAndNumber);
        if (success) {
            return "success";
        }
        return "fail";
    }

    @GetMapping("/increase/{skuId}/{number}")
    public String increase(HttpServletRequest request, @PathVariable("skuId") Integer skuId, @PathVariable("number") Integer number) {
        Integer userId = getUserId(request);
        if (userId > 0) {
            boolean success = cartService.add(userId, skuId, number);
            if (success) {
                return "redirect:/cart/" + userId;
            }
        }
        return "fail";
    }

    private Integer getUserId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if ("userId".equals(c.getName())) {
                log.info("userId:" + c.getValue());
                return Integer.valueOf(c.getValue());
            }
        }
        return 0;
    }

    @GetMapping("/decrease/{skuId}/{number}")
    public String decrease(HttpServletRequest request, @PathVariable("skuId") Integer skuId, @PathVariable("number") Integer number) {
        Integer userId = getUserId(request);
        if (userId > 0) {
            boolean success = cartService.delete(userId, skuId, number);
            if (success) {
                return "redirect:/cart/" + userId;
            }
        }
        return "fail";
    }


    /**
     * @param skuId
     * @Method：delete
     * @Description:
     * @return: java.lang.String
     * @Date: 2020/5/22 16:07
     */
    @GetMapping("/delete/{skuId}/{number}")
    public String delete(HttpServletRequest request, @PathVariable("skuId") Integer skuId, @PathVariable("number") Integer number) {

        Integer userId = getUserId(request);
        boolean success = cartService.delete(userId, skuId, number);
        if (success) {
            return "redirect:/cart/" + userId;
        }
        // TODO 返回一个失败的页面
        return "fail";
    }


}
















