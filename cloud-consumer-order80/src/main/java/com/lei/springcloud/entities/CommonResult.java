package com.lei.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// OrderMain80: RPC调用PaymentMain8001: 也要用entities, 所以也要有这个类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String  msg;
    private T       data;

    public CommonResult(Integer code, String msg){
        this(code, msg, null);
    }
}
