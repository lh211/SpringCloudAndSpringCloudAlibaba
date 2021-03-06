package com.lihao.springcloud.controller;

import com.lihao.springcloud.entities.CommonResult;
import com.lihao.springcloud.entities.payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<payment> create(payment payment){


        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<payment> getPayment(@PathVariable("id") Long id){


        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }
}
