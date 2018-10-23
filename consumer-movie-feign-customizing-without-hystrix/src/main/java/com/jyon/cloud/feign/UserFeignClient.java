package com.jyon.cloud.feign;

import com.jyon.cloud.entity.User;
import com.jyon.config.UserFeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Auther: Jyon
 * @Date: 2018/9/24/024 14:46
 * @Description:
 */
@FeignClient(name = "provider-user",configuration = UserFeignConfiguration.class,fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @RequestLine("GET /findById/{id}")
    public User findById(@Param("id") Long id);

}
