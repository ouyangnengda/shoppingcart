package com.zimingsir.cart.controller;

import com.zimingsir.cart.dao.AttributeDAO;
import com.zimingsir.cart.dao.CommodityDAO;
import com.zimingsir.cart.dao.SkuDAO;
import com.zimingsir.cart.pojo.vo.AttributeVO;
import com.zimingsir.cart.pojo.vo.CommodityVO;
import com.zimingsir.cart.service.CommodityService;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 商品相关控制器
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 19:56:00
 **/
@Controller()
@RequestMapping("/commodity")
@Slf4j
public class CommodityController {

    private final SkuDAO skuDAO;
    private final AttributeDAO attributeDAO;
    private final CommodityService commodityService;
    private final CommodityDAO commodityDAO;

    public CommodityController(CommodityService commodityService, CommodityDAO commodityDAO, AttributeDAO attributeDAO, SkuDAO skuDAO) {
        this.commodityService = commodityService;
        this.commodityDAO = commodityDAO;
        this.attributeDAO = attributeDAO;
        this.skuDAO = skuDAO;
    }

    @GetMapping("/{commodityId}")
    public String getCommodity(@PathVariable("commodityId") Integer commodityId, Model model) {

        CommodityVO commodity = commodityService.getCommodityById(commodityId);
        List<AttributeVO> attributes = attributeDAO.getByCommodity(commodityId);

        if (commodity != null && attributes != null) {
            model.addAttribute("commodity", commodity);
            model.addAttribute("attributes", attributes);
            return "commodity";
        }
        return null;
    }

    @GetMapping("/showCommodity")
    public String showCommodity(Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (!"userId".equals(c.getName())) {
                Cookie cookie = new Cookie("userId", "1");
                cookie.setMaxAge(1000 * 60 * 60);
                cookie.setPath("/");
                log.info("userId插入成功");
                response.addCookie(cookie);
                break;
            }
        }
        List<CommodityVO> commodities = commodityDAO.getAllCommodity();
        model.addAttribute("commodities", commodities);
        return "searchResult";
    }
}
