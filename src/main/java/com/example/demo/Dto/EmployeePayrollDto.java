package com.example.demo.Dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

/**
 * Using @Data is equivalent to
 * using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
 * Generates getters for all fields, a useful toString method, and hashCode and
 * equals implementations that check all non-transient fields.
 */
@Data
public class EmployeePayrollDto {

	@NotEmpty(message = "Employee name cannot be empty")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
	public String empName;
	@Min(value = 500, message = "Salary should be more than 500")
	public long salary;

	public EmployeePayrollDto(String empName, long salary) {
		this.empName = empName;
		this.salary = salary;
	}

}
