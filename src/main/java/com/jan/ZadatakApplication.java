package com.jan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EntityScan(basePackages = {"com.jan.model.user", "com.jan.model.product", "com.jan.model.category"})
@EnableWebSecurity
//@EnableCaching
public class ZadatakApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZadatakApplication.class, args);
	}
}

