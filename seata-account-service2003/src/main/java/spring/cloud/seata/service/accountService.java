package spring.cloud.seata.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface accountService {
    void decrease(Long userId, BigDecimal money) throws InterruptedException;
}
