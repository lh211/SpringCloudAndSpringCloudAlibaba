package com.lihao.springcloud.controller;

import com.lihao.springcloud.entities.CommonResult;

import com.lihao.springcloud.entities.payment;
import com.lihao.springcloud.service.PaymentFeignService;
import com.lihao.springcloud.service.PaymentFeignService8003;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-20 0:05
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentTimeOutFallbackMethods")
public class OrderFeignController
{
    @Resource
    private PaymentFeignService8003 paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod")
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public CommonResult<payment> getPaymentById(@PathVariable("id") Long id) throws InterruptedException {
        if (id<0){
            throw new RuntimeException();
        }
        return paymentFeignService.getPaymentById(id);
    }


    public CommonResult<payment> paymentTimeOutFallbackMethod(@PathVariable("id") Long id) throws InterruptedException {
        return new CommonResult(7677777,"fallback"+id,null);
    }

    public CommonResult<payment> paymentCircuitBreaker_fallback(@PathVariable("id") Long id)  {
        return new CommonResult(888888,"DefaultProperties"+id,null);
    }



}
