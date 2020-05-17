package com.zimingsir.cart.controller;

import com.zimingsir.cart.dao.AttributeDAO;
import com.zimingsir.cart.dao.CommodityDAO;
import com.zimingsir.cart.dubbo.ShoppingCartApi;
import com.zimingsir.cart.pojo.vo.AttributeVO;
import com.zimingsir.cart.pojo.vo.CommodityVO;
import com.zimingsir.cart.service.CommodityService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
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
    private final AttributeDAO attributeDAO;
    private final CommodityService commodityService;
    private final CommodityDAO commodityDAO;
    public CommodityController(CommodityService commodityService, CommodityDAO commodityDAO, AttributeDAO attributeDAO) {
        this.commodityService = commodityService;
        this.commodityDAO = commodityDAO;
        this.attributeDAO = attributeDAO;
    }

    @Reference
    ShoppingCartApi cart;

    @GetMapping("/{commodityId}")
    public String getCommodity(@PathVariable("commodityId") Integer commodityId, Model model) {
        CommodityVO commodity = commodityService.getCommodityById(commodityId);
        if (commodity != null) {
            model.addAttribute("commodity", commodity);
        }
        List<AttributeVO> attributes = attributeDAO.getAttributeByCommodityId(commodityId);
        model.addAttribute("attributes", attributes);
        return "commodity";
    }

    @PostMapping("/addInCart")
    public String addInCart(@RequestParam("selectIndex") String selectIndex) {
        log.info("到了addInCart");
        log.info(selectIndex);
        return "";
    }

    @GetMapping("/showCommodity")
    public String showCommodity(Model model) {
        List<CommodityVO> commodities = commodityDAO.getAllCommodity();
        model.addAttribute("commodities", commodities);
        return "searchResult";
    }
}
