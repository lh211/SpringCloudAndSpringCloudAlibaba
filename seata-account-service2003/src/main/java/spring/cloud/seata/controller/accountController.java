package spring.cloud.seata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.seata.entity.CommonResult;
import spring.cloud.seata.service.accountService;

import java.math.BigDecimal;

@RestController
public class accountController{

    @Autowired
    spring.cloud.seata.service.accountService accountService;

    @PostMapping("/account/update")
    public CommonResult storageUpdate(Long userId, BigDecimal money) throws InterruptedException {
        accountService.decrease(userId,money);
        return new CommonResult(200,"支付成功！！！");

    }
}