package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
/**
 * Using Lombok For Logging
 */
@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollAppApplication.class, args);
		System.out.println("Welcome to EmployeePayroll APP");
		log.info("Employee Payroll App has Started");
	}
}
