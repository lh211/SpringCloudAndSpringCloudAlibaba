package com.lihao.springcloud.service.impl;


import com.lihao.springcloud.Dao.PaymentDao;
import com.lihao.springcloud.entities.payment;
import com.lihao.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceimpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(payment payment) {
        int i = paymentDao.create(payment);
        return i;
    }

    @Override
    public payment getPaymentById(Long id) {
        payment paymentById = paymentDao.getPaymentById(id);
        return paymentById;
    }
}
