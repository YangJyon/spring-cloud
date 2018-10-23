package com.jyon.cloud.controller;

import com.jyon.cloud.entity.User;
import com.jyon.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

   /**
    * @Date: 2018/9/21/021 23:17
    * @Description: TODO
    * @Param: [id]
    * @Return: com.jyon.cloud.entity.User
    */
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Long id){
        return userRepository.findOne(id);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public ServiceInstance instanceInfo() {
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

    @PostMapping("postUser")
    public User postUser(@RequestBody User user){
        return user;
    }

    //该请求不会成功
    @GetMapping("getUser")
    public User getUser(User user){
        return user;
    }

    @GetMapping("listAll")
    public List<User> listAll(){
        return userRepository.findAll();
    }
}
