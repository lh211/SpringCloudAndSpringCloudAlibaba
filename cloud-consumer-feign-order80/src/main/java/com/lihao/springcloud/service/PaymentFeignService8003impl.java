package com.lihao.springcloud.service;


import com.lihao.springcloud.entities.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignService8003impl implements PaymentFeignService8003{
    @Override
    public CommonResult getPaymentById(Long id) throws InterruptedException {
        return new CommonResult(666666,"feignFallback,查询ID: "+id,null);
    }
}
