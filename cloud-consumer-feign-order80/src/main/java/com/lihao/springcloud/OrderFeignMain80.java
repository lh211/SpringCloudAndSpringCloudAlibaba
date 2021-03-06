package com.lihao.springcloud;

import com.lihao.Ribbon.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @auther zzyy
 * @create 2020-02-19 23:57
 */
@SpringBootApplication
@EnableFeignClients
@RibbonClient( name = "CLOUD-PROVIDER-PAYMENT8003", configuration = MySelfRule.class)
@EnableCircuitBreaker
@EnableHystrix
public class OrderFeignMain80
{
    public static void main(String[] args) {
            SpringApplication.run(OrderFeignMain80.class, args);
    }
}
