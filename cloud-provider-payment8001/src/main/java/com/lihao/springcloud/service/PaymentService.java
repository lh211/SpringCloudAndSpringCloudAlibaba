package com.lihao.springcloud.service;


import com.lihao.springcloud.entities.payment;

public interface PaymentService {
     int create(payment payment);

    public payment getPaymentById(Long id);
}
