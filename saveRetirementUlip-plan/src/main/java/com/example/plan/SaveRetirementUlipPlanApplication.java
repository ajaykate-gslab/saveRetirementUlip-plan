package com.example.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SaveRetirementUlipPlanApplication extends SpringBootServletInitializer{

	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SaveRetirementUlipPlanApplication.class);
	    }
	 
	public static void main(String[] args) {
		SpringApplication.run(SaveRetirementUlipPlanApplication.class, args);
	}

}
