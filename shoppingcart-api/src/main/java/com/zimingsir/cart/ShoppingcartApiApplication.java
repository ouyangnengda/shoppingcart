package com.zimingsir.cart;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class ShoppingcartApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingcartApiApplication.class, args);
    }

}
