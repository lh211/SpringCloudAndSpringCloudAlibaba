package spring.cloud.seata.servive;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.cloud.seata.entity.CommonResult;

import java.math.BigDecimal;


@FeignClient(value = "seata-account-service2003")
public interface accountService {

    @PostMapping("/account/update")
    CommonResult storageUpdate(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
