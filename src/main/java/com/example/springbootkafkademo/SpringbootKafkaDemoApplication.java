package com.example.springbootkafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootKafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKafkaDemoApplication.class, args);
        System.out.println("SpringbootKafka ===> 服务启动成功");
    }

}
