package com.dantebado.springsampledds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DDSApplication {

	public static void main(String[] args) {
		SpringApplication.run(DDSApplication.class, args);
	}

}
