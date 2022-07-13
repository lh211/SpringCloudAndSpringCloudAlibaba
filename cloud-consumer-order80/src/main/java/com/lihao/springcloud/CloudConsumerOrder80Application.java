package com.lihao.springcloud;

import com.lihao.MyselfRule.RibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT8001",configuration = RibbonRule.class)
public class CloudConsumerOrder80Application {

    public static void main(String[] args) {


        SpringApplication.run(CloudConsumerOrder80Application.class, args);
    }

}
