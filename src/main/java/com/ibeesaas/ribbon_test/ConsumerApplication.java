package com.ibeesaas.ribbon_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    //  通 过@ EnableDiscoveryClient 注 解 让 该 应 用 注 册 为 Eureka 客 户 端 应 用，
    //  以 获 得 服 务 发 现 的 能 力。
    //  同 时， 在 该 主 类 中 创 建 RestTemplate 的 Spring Bean 实 例，
    //  并 通 过@ LoadBalanced 注 解 开 启 客 户 端 负 载 均 衡。


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
