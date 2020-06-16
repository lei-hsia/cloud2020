package com.lei.springcloud.dao;

import com.lei.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    // mapper.xml: useGeneratedKeys: return int
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
