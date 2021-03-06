package com.lei.springcloud.service;

import com.lei.springcloud.dao.PaymentDao;
import com.lei.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return  paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }

}
