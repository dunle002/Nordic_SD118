package com.example.Nordic_SD118;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.example.Nordic_SD118.service.imp")
@ComponentScan("com.example.Nordic_SD118.repository")
public class NordicSd118Application {

	public static void main(String[] args) {
		SpringApplication.run(NordicSd118Application.class, args);
	}
}
