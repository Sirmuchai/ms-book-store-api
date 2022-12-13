package com.sity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class MsCrudBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCrudBookStoreApplication.class, args);
	}

}
