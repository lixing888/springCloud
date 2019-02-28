package com.example.servicefeign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ServicefeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicefeignApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")// http://127.0.0.1:8763/hi?name=fys
	public String home(@RequestParam String name){
		return "hello My mane is " + name + ",I am from port:" + port;
	}
}
