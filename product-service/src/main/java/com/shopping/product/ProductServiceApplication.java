package com.shopping.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.shopping.product",
		"com.shopping.common.entity",
		"com.shopping.exception"
})
@EntityScan(basePackages = {
		"com.shopping.common.entity"
})
@EnableJpaRepositories(basePackages = {
        "com.shopping.product.repository"
})
public class ProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}
