package com.jyon.cloud.controller;

import com.jyon.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: Jyon
 * @Date: 2018/9/22/022 9:59
 * @Description:
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback"/*,commandProperties = @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")*/)
    public User findById(@PathVariable  Long id){
        // provider-user --> http://localhost:7900/
        return restTemplate.getForObject("http://provider-user/findById/"+id,User.class);
    }

    public User findByIdFallback(@PathVariable  Long id){
        User user = new User();
        user.setId(0L);
        user.setName("Jyon");
        return user;
    }
}
