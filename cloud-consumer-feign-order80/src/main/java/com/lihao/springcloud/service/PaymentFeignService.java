package com.lihao.springcloud.service;

import com.lihao.springcloud.entities.CommonResult;

import com.lihao.springcloud.entities.payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther zzyy
 * @create 2020-02-19 23:59
 */

@FeignClient("CLOUD-PROVIDER-PAYMENT8001")
public interface PaymentFeignService
{
    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);
}
