package com.jyon.cloud.feign;

/**
 * @Auther: Jyon
 * @Date: 2018/10/14/014 15:47
 * @Description:
 */
public class EurekaFeignClientFallback implements  EurekaFeignClient{
    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "haha";
    }
}
