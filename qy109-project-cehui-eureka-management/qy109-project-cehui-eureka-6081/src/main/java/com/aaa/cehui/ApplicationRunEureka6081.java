package com.aaa.cehui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author ltl
 * @Date 2020/7/15  15:12
 * @Description
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRunEureka6081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunEureka6081.class,args);
    }
}
