package com.varchar6.petcast.servicemember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMemberApplication.class, args);
	}

}
