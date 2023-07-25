package com.nudt.springbootsentinel.Controller;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
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

    public void initDegradeRule() {
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource("KEY");
        degradeRule.setCount(10);
        //熔断策略：秒级RT（默认）、秒级异常比例、分钟级异常数。
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        //熔断降级的时间窗口，单位s。触发熔断降级之后多长时间内自动熔断。
        degradeRule.setTimeWindow(10);
        //触发的异常熔断最小请求数，请求数小于该值时即时异常比例超出阀值也不会触发熔断，默认 5s。
        degradeRule.setMinRequestAmount(5);
        //在RT模式下，1s内持续输出多少个请求的平均RT超出阀值后触发熔断，默认 5s。
        degradeRule.setRtSlowRequestAmount(5);
        rules.add(degradeRule);
        DegradeRuleManager.loadRules(rules);
    }

    public void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //设置需要保护的资源，必须与SphU中的相同
        rule.setResource("doSomething");
        //限流阀值类型，QPS模式|并发线程数模式
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //每秒最多允许通过1个请求
        rule.setCount(1);
        //是否需要针对调用来源进行限流，默认default，不区分调用来源
        rule.setLimitApp("default");
        //调用关系限流策略：直接、链路、关联
        rule.setStrategy(RuleConstant.STRATEGY_CHAIN);
        //流控行为：直接拒绝（默认），排队等待，慢启动。
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        //是否是集群限流，默认否
        rule.setClusterMode(false);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
