package com.lei.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    // http远程调用另外的服务, OrderController服务没有直接xxxService资源对象调用，所以要用RestTemplate远程调用;
    // 这个RestTemplate需要首先注入Spring容器: 用@Configuration和@Bean
    @Bean
    @LoadBalanced // 给restTemplate负载均衡的能力，就可以通过服务名称，绕过服务后面多台主机，直接访问
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
