package com.ibeesaas.ribbon_test.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public Object helloService() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", Object.class);
    }

    public String helloFallback() {
        return "error";
    }

}
