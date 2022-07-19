package com.lihao.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Dashboard9001Applicaton {
    public static void main(String[] args) {
        SpringApplication.run(Dashboard9001Applicaton.class, args);
    }

}
