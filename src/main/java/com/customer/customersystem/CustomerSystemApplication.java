package com.customer.customersystem;

import com.customer.customersystem.repositories.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class CustomerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSystemApplication.class, args);
	}

}
