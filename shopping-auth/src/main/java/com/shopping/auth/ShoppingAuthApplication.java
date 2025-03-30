package com.shopping.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.shopping.auth",
		"com.shopping.common.entity",
		"com.shopping.exception"
})
@EntityScan(basePackages = {
		"com.shopping.common.entity"
})
@EnableJpaRepositories(basePackages = {
		"com.shopping.auth.repository"
})
public class ShoppingAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingAuthApplication.class, args);
	}
}
