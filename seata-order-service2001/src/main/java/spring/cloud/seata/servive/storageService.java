package spring.cloud.seata.servive;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.cloud.seata.entity.CommonResult;


@FeignClient(value = "seata-storage-service2002")
public interface storageService {
    @PostMapping("/storage/update")
    CommonResult storageUpdate(@RequestParam("productId")Long productId, @RequestParam("count")Integer count);
}
