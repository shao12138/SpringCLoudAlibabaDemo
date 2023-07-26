package com.nudt.springcloudsentinel.Config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import com.alibaba.csp.sentinel.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class CustomUrlClearner implements UrlCleaner {
    public String clean(String s) {
        if (StringUtil.isEmpty(s)){
            return s;
        }
        if (s.startsWith("/clean")){
            return "/clean/*";
        }
        return s;
    }
}
