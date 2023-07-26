package com.nudt.springcloudsentinel.Controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @SentinelResource(value = "hello", blockHandler = "blockHandlerHello")
    @GetMapping("/say")
    public String hello() {
        return "hello, word!";
    }

    public String blockHandlerHello(BlockException e) {
        return "当前访问人数过多！";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Bye~~~";
    }

    @GetMapping("/clean/{id}")
    public String clean(@PathVariable("id") int id) {
        return "Hello " + id;
    }
}
