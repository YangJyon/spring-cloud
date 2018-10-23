package com.jyon.cloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Jyon
 * @Date: 2018/9/23/023 20:23
 * @Description:
 */
@Configuration
@ExcludeFromComponentScan
public class RibbonConfiguration {

    /*
     * @Date: 2018/9/23/023 21:46
     * @Description: 随机策略
     * @Param: []
     * @Return: com.netflix.loadbalancer.IRule
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
