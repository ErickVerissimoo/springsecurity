package com.loginsecurity.springloginsecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringloginsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringloginsecurityApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(){
		return args -> System.out.println("Aplicação em funcionamento");
	}

}
