package com.jyon.cloud.controller;

import com.jyon.cloud.entity.User;
import com.jyon.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Jyon
 * @Date: 2018/9/22/022 9:59
 * @Description:
 */
@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable  Long id){
        return userFeignClient.findById(id);
    }

    @GetMapping("/testPost")
    public User testPost(User user){
        return userFeignClient.postUser(user);
    }

    //该请求不会成功
    @GetMapping("/testGet")
    public User testGet(User user){
        return userFeignClient.getUser(user);
    }
}
