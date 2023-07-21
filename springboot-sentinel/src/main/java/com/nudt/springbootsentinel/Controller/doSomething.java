package com.nudt.springbootsentinel.Controller;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class doSomething {
    @RequestMapping("/do")
    @SentinelResource(value = "doSomething", blockHandler = "blockHandler")
    public void say() {
        initFlowRules();
        System.out.println("hello, world" + System.currentTimeMillis());
    }

    public static void blockHandler(BlockException e) {
        System.out.println("限流后调用方法");
    }

    public void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //设置需要保护的资源，必须与SphU中的相同
        rule.setResource("doSomething");
        //限流阀值类型，QPS模式|并发线程数模式
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //每秒最多允许通过20个请求
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
