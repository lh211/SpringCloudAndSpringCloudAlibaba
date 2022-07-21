package com.lihao.springcloud.controller;


import com.lihao.springcloud.entities.CommonResult;
import com.lihao.springcloud.entities.payment;
import com.lihao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    String port;

    @Autowired
    PaymentService paymentService;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);


        if(result > 0)
        {
            return new CommonResult(200,"插入数据库成功,serverPort: "+port,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) throws InterruptedException {

//        Thread.sleep(3000);
        payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果");

        if(payment != null) {
            return new CommonResult(200,"查询成功,serverPort:  "+port,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        }
    }


}
