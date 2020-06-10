package com.lei.springcloud.service;

import com.lei.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
