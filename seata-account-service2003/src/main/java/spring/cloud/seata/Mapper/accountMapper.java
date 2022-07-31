package spring.cloud.seata.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface accountMapper {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
