package com.shopping.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.shopping.order",
		"com.shopping.common.entity",
		"com.shopping.exception"
})
@EntityScan(basePackages = {
		"com.shopping.common.entity"
})
@EnableJpaRepositories(basePackages = {
        "com.shopping.order.repository"
})
public class OrderServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}

