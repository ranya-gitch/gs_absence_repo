package com.ensah.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AbsenceManagementBootApplication {



	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AbsenceManagementBootApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AbsenceManagementBootApplication.class, args);
	}

}
