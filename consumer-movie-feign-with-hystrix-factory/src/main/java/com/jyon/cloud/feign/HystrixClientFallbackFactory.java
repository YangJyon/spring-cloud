package com.jyon.cloud.feign;

import com.jyon.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: Jyon
 * @Date: 2018/10/14/014 16:56
 * @Description:
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient>{
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {

        LOGGER.info("fallback; reason was: " + throwable.getMessage());

        return new UserFeignClientWithFactory() {
            @Override
            public User findById(Long id) {
                User user = new User();
                user.setId(-1L);
                user.setName("Jyon");
                return user;
            }
        };
    }
}
