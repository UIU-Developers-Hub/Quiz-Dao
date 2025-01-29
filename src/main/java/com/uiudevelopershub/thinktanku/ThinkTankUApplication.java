package com.uiudevelopershub.thinktanku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ThinkTankUApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkTankUApplication.class, args);
	}

}
