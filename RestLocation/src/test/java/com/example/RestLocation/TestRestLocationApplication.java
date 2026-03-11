package com.example.RestLocation;

import org.springframework.boot.SpringApplication;

public class TestRestLocationApplication {

	public static void main(String[] args) {
		SpringApplication.from(RestLocationApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
