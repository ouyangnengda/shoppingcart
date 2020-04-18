package com.zimingsir.support.controller;

import com.zimingsir.support.pojo.Commodity;
import com.zimingsir.support.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 商品相关控制器
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 19:56:00
 **/
@Controller("/commodity")
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/{commodityId}")
    public String getCommodity(@PathVariable("commodityId") Integer commodityId, Model model) {
        Commodity commodity = commodityService.getCommodityById(commodityId);
        if (commodity != null) {
            model.addAttribute(commodity);
        }
        return "commodity";
    }
}
