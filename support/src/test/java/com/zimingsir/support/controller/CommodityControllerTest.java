package com.zimingsir.support.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
class CommodityControllerTest {

    @Autowired
    private CommodityController commodityController;

    @Before
    public void setupMockMvc() {
        log.info("注入mockMvc");
    }

    @Test
    void showCommodity() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(commodityController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/commodity/showCommodity"))
                .andExpect(status().isOk())
                .andExpect(view().name("searchResult"))
                .andExpect(model().attributeExists("commodities"))
                .andReturn();

    }

    @Test
    void getCommodity() {
    }
}