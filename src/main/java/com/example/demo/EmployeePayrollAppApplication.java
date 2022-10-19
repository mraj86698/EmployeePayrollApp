package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * Using Lombok For Logging
 */
@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
		System.out.println("Welcome to EmployeePayroll APP");
		log.info("Application Started");

		log.info("Employee Payroll App has Started in {} Environment",context.getEnvironment().getProperty("environment"));
        log.info("Database : User Name is {}",context.getEnvironment().getProperty("spring.datasource.username"));
	}
}
