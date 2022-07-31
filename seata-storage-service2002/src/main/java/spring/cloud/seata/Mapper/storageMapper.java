package spring.cloud.seata.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface  storageMapper {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
