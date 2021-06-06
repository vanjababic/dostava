package com.iis.dostava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.iis.dostava"})
public class DostavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DostavaApplication.class, args);
	}

}
