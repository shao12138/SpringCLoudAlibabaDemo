package com.nudt.springcloudnacosdiscoveryprovider.Service;

import com.nudt.sampleapi.Service.IHelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements IHelloService {
    public String sayHello(String name) {
        return "Hello World：" + name;
    }
}
