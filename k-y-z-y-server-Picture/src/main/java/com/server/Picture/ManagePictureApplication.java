package com.server.Picture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.server.model")//扫描实体类
@ComponentScan(basePackages={"com.server.api.recipe"})//扫描接口
@ComponentScan(basePackages={"com.server.Picture"})
public class ManagePictureApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagePictureApplication.class,args);
    }
}
