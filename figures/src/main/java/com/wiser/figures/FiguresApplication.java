package com.wiser.figures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FiguresApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiguresApplication.class, args);
		CLI.startCLI();
	}
}
