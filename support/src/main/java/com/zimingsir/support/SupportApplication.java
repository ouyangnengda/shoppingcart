package com.zimingsir.support;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zimingsir.support.dao")
@EnableDubbo
public class SupportApplication {

    public static void main(String[] args) {

        SpringApplication.run(SupportApplication.class, args);
    }

}
