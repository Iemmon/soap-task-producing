package com.soap.producing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ProducingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducingApplication.class, args);
	}

}
