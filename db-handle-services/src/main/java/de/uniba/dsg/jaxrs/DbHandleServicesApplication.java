package de.uniba.dsg.jaxrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DbHandleServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbHandleServicesApplication.class, args);
	}

}
