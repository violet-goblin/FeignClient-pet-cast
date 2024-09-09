package com.varchar6.petcast.serviceconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServiceConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigurationApplication.class, args);
	}

}
