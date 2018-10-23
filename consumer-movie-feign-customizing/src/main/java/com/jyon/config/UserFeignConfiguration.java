package com.jyon.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Jyon
 * @Date: 2018/9/24/024 15:52
 * @Description:
 */
@Configuration
public class UserFeignConfiguration {
    //使用Feign自己的注解，使用springmvc的注解就会报错
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
    //feign日志
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
