package com.server.YSTControl;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;

@SpringBootApplication
@EntityScan("com.server.model")//扫描实体类
@ComponentScan(basePackages={"com.server.api.UserControl"})//扫描接口
@ComponentScan(basePackages={"com.server.YSTControl"})
@ComponentScan(basePackages={"com.server.UserControl"})
public class ManageYSTApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageYSTApplication.class,args);
    }

//    @Test
//    public void Test(){
//        ArrayList<Object> lis = new ArrayList<>();
//        lis.add(1);
//        lis.add(2);
//        lis.add(3);
//
//        ArrayList<Object> list = new ArrayList<>();
//        list.add(3);
//        list.add(4);
//        list.add(5);
//
//        list.addAll(0,lis);
//        System.out.println(list);
//    }
}
