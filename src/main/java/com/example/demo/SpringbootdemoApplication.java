package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EntityScan("com.example")
@EnableJpaRepositories("com.example")
@ComponentScan("com.example")
@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
}
