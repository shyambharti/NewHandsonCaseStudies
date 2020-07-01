package com.ibm.user.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class UserAuthenticationSecurityJwtServiceApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationSecurityJwtServiceApplication.class, args);
	}

}
