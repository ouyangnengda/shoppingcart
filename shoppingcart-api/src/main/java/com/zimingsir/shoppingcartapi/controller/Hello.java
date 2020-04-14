package com.zimingsir.shoppingcartapi.controller;

import com.zimingsir.shoppingcartapi.pojo.Student;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年04月14日 16:14:00
 **/
@Slf4j
@RestController
@RequestMapping("/hello")
public class Hello {

    @GetMapping("/test")
    public Student test() {
        log.info("info:test");
        log.error("info:test");
        Student s = new Student();
        s.setId(1);
        s.setName("小明");

        return s;
    }
}
