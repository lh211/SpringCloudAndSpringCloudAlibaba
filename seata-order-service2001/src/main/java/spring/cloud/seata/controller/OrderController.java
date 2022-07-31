package spring.cloud.seata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.seata.entity.CommonResult;
import spring.cloud.seata.entity.Order;
import spring.cloud.seata.servive.orderService;

@RestController
public class OrderController {

    @Autowired
    spring.cloud.seata.servive.orderService orderService;

    @GetMapping("/order/create")
    public CommonResult orderCreate(Order order){
        orderService.crete(order);
        return new CommonResult(200,"创建订单成功！！！");

    }
}
