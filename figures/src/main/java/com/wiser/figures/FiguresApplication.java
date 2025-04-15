package com.wiser.figures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FiguresApplication {

	public static void main(String[] args) {
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);

		double a = 0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000049;
		System.out.println(a);
//		SpringApplication.run(FiguresApplication.class, args);
	}

}
