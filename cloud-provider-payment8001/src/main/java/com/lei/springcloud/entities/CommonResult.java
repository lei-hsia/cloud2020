package com.lei.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String  msg;
    private T       data;

    public CommonResult(Integer code, String msg){
        this(code, msg, null); // 直接调用this的构造方法就行了
    }
}
