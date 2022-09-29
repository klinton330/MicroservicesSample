package com.hari.microserviceapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({ @ComponentScan("com.hari.")})
public class MicroserviceApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApp1Application.class, args);
	}

}
