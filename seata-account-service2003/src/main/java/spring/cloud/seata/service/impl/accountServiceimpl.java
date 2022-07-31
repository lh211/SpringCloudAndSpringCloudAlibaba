package spring.cloud.seata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.cloud.seata.Mapper.accountMapper;
import spring.cloud.seata.service.accountService;

import java.math.BigDecimal;

@Service
public class accountServiceimpl implements accountService {
    @Autowired
    spring.cloud.seata.Mapper.accountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) throws InterruptedException {
        Thread.sleep(20000);
        accountMapper.decrease(userId,money);

    }
}
