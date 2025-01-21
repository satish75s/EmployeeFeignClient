package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeFeignClientApplication.class, args);
	}

}
