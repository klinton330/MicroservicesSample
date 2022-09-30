package com.hari.microserviceapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScans({ @ComponentScan("com.hari.")})
@EntityScan("com.hari.entity")
@EnableJpaRepositories("com.hari.repository")
public class MicroserviceApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApp1Application.class, args);
	}

}
