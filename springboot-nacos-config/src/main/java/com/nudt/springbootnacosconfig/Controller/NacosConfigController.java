package com.nudt.springbootnacosconfig.Controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NacosPropertySource(dataId = "test", autoRefreshed = true)
public class NacosConfigController {
    //其中info表示key，如果不存在使用默认值：Hello World。
    @NacosValue(value = "${info: Local Hello World}", autoRefreshed = true)
    private String info;

    @GetMapping("/config")
    public String get() {
        return info;
    }
}
