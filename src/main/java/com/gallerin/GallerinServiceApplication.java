package com.gallerin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EntityScan("com.gallerin.domain")
public class GallerinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GallerinServiceApplication.class, args);
	}
	
	 @Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
	     return new BCryptPasswordEncoder();
	 }
}
