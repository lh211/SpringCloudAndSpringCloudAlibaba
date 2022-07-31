package spring.cloud.seata.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.cloud.seata.Mapper.storageMapper;
import spring.cloud.seata.service.storageService;


@Service
@Slf4j
public class storageServiceImpl implements storageService {
    @Autowired
    storageMapper storageMapper;
    @Override
    public void decrease(Long productId, Integer count) {
        storageMapper.decrease(productId,count);
        log.info("=======================库存扣减成功");

    }
}
