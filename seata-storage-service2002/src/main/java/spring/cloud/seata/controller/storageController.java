package spring.cloud.seata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.seata.entity.CommonResult;
import spring.cloud.seata.service.storageService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@RestController
public class storageController {

    @Autowired
    storageService storageService;

    @PostMapping("/storage/update")
    public CommonResult storageUpdate(Long productId,Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"库存扣减成功");

    }
}
