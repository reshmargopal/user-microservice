package com.user.userclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.user.userclientservice.feign")
public class UserClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserClientServiceApplication.class, args);
	}

}
