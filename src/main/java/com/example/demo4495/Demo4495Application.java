package com.example.demo4495;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication()
@EnableConfigurationProperties
public class Demo4495Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo4495Application.class, args);
	}
}
