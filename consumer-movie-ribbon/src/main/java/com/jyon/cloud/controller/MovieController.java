package com.jyon.cloud.controller;

import com.jyon.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Jyon
 * @Date: 2018/9/22/022 9:59
 * @Description:
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable  Long id){
        // provider-user --> http://localhost:7900/
        return restTemplate.getForObject("http://provider-user/findById/"+id,User.class);
    }

    @GetMapping("/test")
    public String test(){
        //随机
        ServiceInstance serviceInstance1 = loadBalancerClient.choose("provider-user");
        System.out.println(serviceInstance1.getServiceId()+":"+serviceInstance1.getHost()+":"+serviceInstance1.getPort());
        //轮询(默认)
        ServiceInstance serviceInstance2 = loadBalancerClient.choose("provider-user2");
        System.out.println(serviceInstance2.getServiceId()+":"+serviceInstance2.getHost()+":"+serviceInstance2.getPort());
        return "success";
    }

    @GetMapping("listAll")
    public List<User> listAll(){
//        List<User> list1 = restTemplate.getForObject("http://provider-user/listAll",List.class);
//        //此处转User会报错
//        for (User user: list1) {
//            System.out.println(user.getName());
//        }
        User[] users = restTemplate.getForObject("http://provider-user/listAll",User[].class);
        List<User> list2 = Arrays.asList(users);
        for (User user: list2) {
            System.out.println(user.getName());
        }
        return list2;
    }
}
