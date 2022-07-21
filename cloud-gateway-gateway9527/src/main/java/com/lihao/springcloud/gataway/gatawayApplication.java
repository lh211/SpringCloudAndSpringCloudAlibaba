package com.lihao.springcloud.gataway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class gatawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(gatawayApplication.class, args);
    }
}
