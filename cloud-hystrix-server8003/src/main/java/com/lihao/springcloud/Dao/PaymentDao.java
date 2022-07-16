package com.lihao.springcloud.Dao;

import com.lihao.springcloud.entities.payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface PaymentDao {

    public int create(payment payment);

    public payment getPaymentByIds(@Param("id") Long id);
}
