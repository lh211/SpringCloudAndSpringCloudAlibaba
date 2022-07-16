package com.lihao.springcloud.service;


import com.lihao.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PROVIDER-PAYMENT8003",fallback = PaymentFeignService8003impl.class)
public interface PaymentFeignService8003 {
    @GetMapping(value = "/payment/get/{id}")

    public CommonResult getPaymentById(@PathVariable("id") Long id) throws InterruptedException ;

}
