package com.lei.springcloud.controller;

import com.lei.springcloud.entities.CommonResult;
import com.lei.springcloud.entities.Payment;
import com.lei.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")  // ${} 获取配置文件中的K对应的value
    private String serverPort;

    // 糊涂了: 为什么是本地的8001调用: http://localhost:8001/payment/get/31; 不是192.168.68.146
    // 因为那个只是数据库在别的地方，实际上IDEA启动的spring服务都是在本地运行的，所以本地浏览器测试

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******* 返回结果： " + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功, serverPort" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Integer> getPaymentById(@PathVariable("id")Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******* 返回结果： " + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功, serverPort" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败", null);
        }
    }
}
