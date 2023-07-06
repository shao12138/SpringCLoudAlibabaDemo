package com.nudt.clouddubbosampleconsumer.Controller;

import com.nudt.sampleapi.Service.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Reference
    private IHelloService iHelloService;

    @GetMapping("/say")
    public String sayHello() {
        System.out.println("你好");
        return iHelloService.sayHello("Alibaba");
    }
}

