package com.nudt.sampleconsumer.Service;

import com.nudt.sampleapi.Service.IHelloService;

public class DegradationHelloService implements IHelloService {
    public String sayHello(String name) {
        return "降级处理";
    }
}
