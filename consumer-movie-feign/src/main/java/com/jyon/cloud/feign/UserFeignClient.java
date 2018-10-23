package com.jyon.cloud.feign;

import com.jyon.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: Jyon
 * @Date: 2018/9/24/024 14:46
 * @Description:
 */
@FeignClient("provider-user")
public interface UserFeignClient {
    //两个坑：1、@GetMapping不支持 2、@PathVariable得设置value
    @RequestMapping(method = RequestMethod.GET, value = "/findById/{id}")
    public User findById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/postUser")
    public User postUser(@RequestBody User user);

    //该请求不会成功，只要参数是复杂对象，即使指定了GET方法，feign依然会以POST方法进行发送请求
    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    public User getUser(User user);

}
