package com.shopping.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.shopping.payment",
		"com.shopping.common.entity",
		"com.shopping.exception"
})
@EntityScan(basePackages = {
		"com.shopping.common.entity"
})
@EnableJpaRepositories(basePackages = {
        "com.shopping.payment.repository"
})
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}

