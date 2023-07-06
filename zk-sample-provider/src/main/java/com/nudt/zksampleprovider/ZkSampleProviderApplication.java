package com.nudt.zksampleprovider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class ZkSampleProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkSampleProviderApplication.class, args);
    }
}
