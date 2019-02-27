package com.servicehi.servicehi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient //加入注解@EnableEurekaClient，表明自己属于一个生产者
public class ServicehiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicehiApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")// http://127.0.0.1:8763/hi?name=fys
	public String home(@RequestParam String name){
		return "hello My mane is " + name + ",I am from port:" + port;
	}


}
