package com.jyon.cloud.feign;

import com.jyon.cloud.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Auther: Jyon
 * @Date: 2018/10/14/014 15:17
 * @Description:
 */
@Component
public class HystrixClientFallback implements UserFeignClient{
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        user.setName("Jyon");
        return user;
    }
}
