package com.groupware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Nkw2Application {

	public static void main(String[] args) {
		SpringApplication.run(Nkw2Application.class, args);
	}

}
