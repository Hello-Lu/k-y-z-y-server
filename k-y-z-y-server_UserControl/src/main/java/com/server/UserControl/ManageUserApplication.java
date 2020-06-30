package com.server.UserControl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.server.model")//扫描实体类
@ComponentScan(basePackages={"com.server.api.UserControl"})//扫描接口
@ComponentScan(basePackages={"com.server.UserControl"})
@ComponentScan(basePackages = {"com.server.utils"})
public class ManageUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageUserApplication.class,args);
    }
}
