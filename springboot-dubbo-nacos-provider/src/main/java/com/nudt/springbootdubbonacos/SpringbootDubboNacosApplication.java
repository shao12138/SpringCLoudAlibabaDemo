package com.nudt.springbootdubbonacos;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class SpringbootDubboNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboNacosApplication.class, args);
    }

}
