package com.nudt.clouddubbosampleprovider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class CloudDubboSampleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDubboSampleProviderApplication.class, args);
    }

}
