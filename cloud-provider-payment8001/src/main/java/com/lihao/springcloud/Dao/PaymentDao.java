package com.lihao.springcloud.Dao;

import org.apache.ibatis.annotations.Mapper;
import com.lihao.springcloud.entities.payment;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface PaymentDao {

    public int create(payment payment);

    public payment getPaymentById(@Param("id") Long id);
}
