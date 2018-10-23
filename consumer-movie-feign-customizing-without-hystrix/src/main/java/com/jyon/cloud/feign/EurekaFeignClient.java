package com.jyon.cloud.feign;

import com.jyon.config.EurekaFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Jyon
 * @Date: 2018/10/7/007 12:20
 * @Description:
 */
@FeignClient(name = "xxx" , url = "http://localhost:8761/",configuration = EurekaFeignConfiguration.class,fallback = EurekaFeignClientFallback.class)
public interface EurekaFeignClient {
    @RequestMapping("/eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);

}
