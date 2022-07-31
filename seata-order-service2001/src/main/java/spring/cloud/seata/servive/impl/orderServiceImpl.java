package spring.cloud.seata.servive.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.cloud.seata.Mapper.orderMapper;
import spring.cloud.seata.entity.Order;
import spring.cloud.seata.servive.accountService;
import spring.cloud.seata.servive.orderService;
import spring.cloud.seata.servive.storageService;


@Service
@Slf4j
public class orderServiceImpl implements orderService {

    @Autowired
    orderMapper orderMapper;

    @Autowired
    accountService accountService;
    @Autowired
    storageService storageService;

    @Override
    @GlobalTransactional
    public void crete(Order order) {
        //1.创建订单
        log.info("----->开始新建订单");
        orderMapper.crete(order);

        //2.远程扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.storageUpdate(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3.远程扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.storageUpdate(order.getUserId(),order.getMoney());

        log.info("----->订单微服务开始调用账户，做扣减end");



        //4.修改订单状态
        log.info("----->修改订单状态开始");
        orderMapper.update(order.getProductId(),order.getStatus());
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");

    }


}
