package com.example.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    // 断路器配置，当无法调用如下方法时，就会调用自定的hiError方法。
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        //return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);

        Object forObject = restTemplate.getForObject("http://127.0.0.1:8763/hi?name=" + name, Object.class);
        return forObject.toString();

    }

    public String hiError(String name){
        return "hey " +
                name + ", there is some problem with hi page";
    }


}
