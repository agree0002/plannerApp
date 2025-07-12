package com.igrus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.igrus.api")
@EnableJpaRepositories(basePackages = "com.igrus.api")
@EntityScan(basePackages = "com.igrus.api")
public class PlanerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanerApplication.class, args);
	}

}
