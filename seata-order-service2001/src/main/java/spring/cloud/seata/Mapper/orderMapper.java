package spring.cloud.seata.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import spring.cloud.seata.entity.Order;

@Mapper
public interface orderMapper {

    void crete(Order order);

    void update(@Param("productId") Long productId,@Param("status") Integer status);
}
