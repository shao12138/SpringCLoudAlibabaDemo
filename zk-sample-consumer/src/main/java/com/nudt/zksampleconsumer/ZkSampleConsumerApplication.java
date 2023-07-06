package com.nudt.zksampleconsumer;

import com.nudt.sampleapi.Service.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZkSampleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkSampleConsumerApplication.class, args);
    }

    @Reference(url = "dubbo://10.60.200.20:12345/com.nudt.sampleapi.Service.IHelloService")
    private IHelloService helloService;

    @Bean
    public ApplicationRunner runner() {
        return args -> System.out.println(helloService.sayHello("Hello, SpringCloud Alibaba!"));
    }
}
