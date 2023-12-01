package com.mljo.springboot3;

import com.mljo.springboot3.config.ContainersConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot3ApplicationTests {

	public static void main(String[] args) {
		SpringApplication.from(Springboot3Application::main)
				.with(ContainersConfig.class)
				.run(args);
	}

}
