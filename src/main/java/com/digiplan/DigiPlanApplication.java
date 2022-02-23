package com.digiplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.digiplan" })
public class DigiPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigiPlanApplication.class, args);
	}

}
