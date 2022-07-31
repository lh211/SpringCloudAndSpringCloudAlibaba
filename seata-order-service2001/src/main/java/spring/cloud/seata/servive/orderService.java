package spring.cloud.seata.servive;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import spring.cloud.seata.Mapper.orderMapper;
import spring.cloud.seata.entity.Order;

public interface orderService {
    void crete(Order order);

//    void update(@Param("productId") Long productId, @Param("status") Integer status);
}
