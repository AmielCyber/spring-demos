package com.amiel.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Explicitly list base packages to scan if code is outside of spring packages like the util package
// @SpringBootApplication(scanBasePackages = {"com.amiel.springcore", "com.amiel.util"})
@SpringBootApplication
public class SpringcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoreApplication.class, args);
	}

}
