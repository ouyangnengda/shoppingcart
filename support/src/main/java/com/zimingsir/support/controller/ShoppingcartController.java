package com.zimingsir.support.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zimingsir.support.Util.VariableUtil;
import com.zimingsir.support.pojo.Commodity;
import com.zimingsir.support.pojo.Token;
import com.zimingsir.support.service.LocalCartService;
import com.zimingsir.support.service.TokenService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: 购物车控制器
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 20:19:00
 **/
@Slf4j
@Controller("/shoppingcart")
public class ShoppingcartController {

    @Autowired
    TokenService tokenService;

    @Autowired
    LocalCartService localCartService;

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response, @RequestParam("Commodity")Commodity commodity) {
        /*Optional<Token> token = Optional.ofNullable(tokenService.getToken(request));
        if (token.isPresent()) {
            Integer userId = token.get().getUserId();
            // TODO 通过dubbo 来调用购物车的add服务,如果添加商品到购物车成功，那么返回添加成功页面，否则返回失败页面。

        }
        // 将修改记录添加到本地购物车
        else {
            Cookie[] cookies = request.getCookies();
            ObjectMapper mapper = new ObjectMapper();
            List<Commodity> commodities;
            List<Commodity> newCommodities;
            for (Cookie cookie : cookies) {
                if (VariableUtil.LOCAL_CART_NAME.equals(cookie.getName())) {
                    try {
                        commodities = Arrays.asList(mapper.readValue(cookie.getValue(), Commodity[].class));

                        newCommodities = localCartService.add(commodities, commodity);

                        // TODO 下面的转换可能有问题
                        String newLocalCart = mapper.convertValue(newCommodities,String.class);
                        Cookie newLocalCartCookie = new Cookie(VariableUtil.LOCAL_CART_NAME, newLocalCart);
                        newLocalCartCookie.setMaxAge(VariableUtil.LOCAL_CART_LIVE_TIME);
                        response.addCookie(newLocalCartCookie);
                    } catch (JsonProcessingException e) {
                        log.error("transfer local cart of json where in cookie to List failed", e);
                    }
                }
            }
        }
        // 返回添加商品成功的页面
        return "addSuccess";
*/
        return "";
    }
}
