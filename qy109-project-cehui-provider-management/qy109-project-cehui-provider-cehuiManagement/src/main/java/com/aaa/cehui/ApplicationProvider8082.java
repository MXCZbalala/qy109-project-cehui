package com.aaa.cehui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author ltl
 * @Date 2020/7/16  19:32
 * @Description
 **/
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class
})
@MapperScan("com.aaa.cehui.mapper")
@EnableEurekaClient
public class ApplicationProvider8082 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationProvider8082.class,args);
    }
}
