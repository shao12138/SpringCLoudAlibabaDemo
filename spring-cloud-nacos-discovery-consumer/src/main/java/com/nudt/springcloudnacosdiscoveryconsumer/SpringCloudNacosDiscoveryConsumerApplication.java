package com.nudt.springcloudnacosdiscoveryconsumer;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class SpringCloudNacosDiscoveryConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosDiscoveryConsumerApplication.class, args);
    }
}
