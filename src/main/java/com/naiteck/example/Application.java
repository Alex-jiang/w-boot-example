package com.naiteck.example;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration

@EnableTransactionManagement
@MapperScan("com.naiteck.example.mapper")
//@EnableDiscoveryClient
//@EnableFeignClients({"com.goodskill.order.api"})
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);
    }
}
