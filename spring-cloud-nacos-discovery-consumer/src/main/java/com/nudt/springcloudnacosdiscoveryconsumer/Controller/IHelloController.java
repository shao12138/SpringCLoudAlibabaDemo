package com.nudt.springcloudnacosdiscoveryconsumer.Controller;

import com.nudt.sampleapi.Service.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IHelloController {
    @Reference
    private IHelloService iHelloService;

    @GetMapping("/say")
    public String sayHello() {
        return iHelloService.sayHello("燕双嘤");
    }
}
