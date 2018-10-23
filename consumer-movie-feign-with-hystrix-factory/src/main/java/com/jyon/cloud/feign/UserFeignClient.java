package com.jyon.cloud.feign;

import com.jyon.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: Jyon
 * @Date: 2018/9/24/024 14:46
 * @Description:
 */
@FeignClient(name = "provider-user",/*fallback = HystrixClientFallback.class,*/fallbackFactory = HystrixClientFallbackFactory.class)
public interface UserFeignClient {
    //两个坑：1、@GetMapping不支持 2、@PathVariable得设置value
    @RequestMapping(method = RequestMethod.GET, value = "/findById/{id}")
    public User findById(@PathVariable("id") Long id);

}
