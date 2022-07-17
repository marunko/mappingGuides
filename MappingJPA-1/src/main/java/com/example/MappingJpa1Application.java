package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MappingJpa1Application {

	public static void main(String[] args) {
		SpringApplication.run(MappingJpa1Application.class, args);
	}

}
