package com.bms;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class BMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(BMSApplication.class, args);
		System.out.println("Running--------------------------------------------------------------------------------------------");
	}

}
