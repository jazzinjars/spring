package com.jazzinjars.spring.springbootjersey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jazzinjars.spring.springbootjersey")
public class SpringBootJerseyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJerseyApplication.class, args);
	}
}
