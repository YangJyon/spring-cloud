package com.jyon.config;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Auther: Jyon
 * @Date: 2018/10/7/007 12:35
 * @Description:
 */
@Configuration
public class EurekaFeignConfiguration {
    //因为eureka设置了密码，用该方法登录
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "123456");
    }
    //禁用feign对hystrix的支持
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
