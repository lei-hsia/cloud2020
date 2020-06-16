package com.lei.springcloud.controller;

import com.lei.springcloud.entities.CommonResult;
import com.lei.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    // 1. IDEA启动的spring服务都是在本地运行的，所以本地浏览器测试, 所以IP不是192.168.68.146而是localhost
    // 2. 端口: 注意这里是用restTemplate调用远程的payment8001服务，所以端口是payment8001的端口
    // private static final String PAYMENT_URL = "http://localhost:8001";

    // 不再通过微服务地址访问，而是通过集群状态的微服务名称访问
    private static final String PAYMENT_SVC = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_SVC +"/payment/create", payment, CommonResult.class); // URL, 携带参数，返回结果
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id) {
        return restTemplate.getForObject(PAYMENT_SVC +"/payment/get/"+id, CommonResult.class); // get请求不携带参数
    }
}
