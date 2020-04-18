package com.zimingsir.support.controller;

import com.zimingsir.support.pojo.Commodity;
import com.zimingsir.support.pojo.Token;
import com.zimingsir.support.service.CommodityService;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: 登陆控制器
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 17:06:00
 **/
@Controller
public class LoginController {

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/")
    public String main(Model model) {

        List<Commodity> commodityList = commodityService.getCommodityList();
        model.addAttribute(commodityList);

        return "commodity";
    }



    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {

        // 判断用户是否启用cookie


        return "login";
    }



    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request) {

    }

}
