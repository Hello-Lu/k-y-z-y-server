package com.server.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.server.model")//扫描实体类
@ComponentScan(basePackages={"com.server.api.recipe"})//扫描接口
@ComponentScan(basePackages={"com.server.recipe"})
public class ManageRecipeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageRecipeApplication.class,args);
    }
}
