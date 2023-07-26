package com.nudt.springcloudsentinel.Config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class SentinelConfig {
   // @Bean
    public SentinelResourceAspect sentinelResourceAspect(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //设置需要保护的资源，必须与SphU中的相同
        rule.setResource("hello");
        //限流阀值类型，QPS模式|并发线程数模式
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //每秒最多允许通过1个请求
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
        return new SentinelResourceAspect();
    }
}
