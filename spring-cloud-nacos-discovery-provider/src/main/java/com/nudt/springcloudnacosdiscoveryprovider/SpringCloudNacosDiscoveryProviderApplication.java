package com.nudt.springcloudnacosdiscoveryprovider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class SpringCloudNacosDiscoveryProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosDiscoveryProviderApplication.class, args);
    }
}
