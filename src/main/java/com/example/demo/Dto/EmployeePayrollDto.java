package com.example.demo.Dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.ToString;

/**
 * Using @Data is equivalent to
 * using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
 * Generates getters for all fields, a useful toString method, and hashCode and
 * equals implementations that check all non-transient fields.
 */
@Data
@ToString
public class EmployeePayrollDto {

	@NotEmpty(message = "Employee name cannot be empty")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
	public String empName;
	@Min(value = 500, message = "Salary should be more than 500")
	@Max(value = 900000, message = "Salary should not exceeds 900000")
	public long salary;
	private String gender;
	private Date startDate;
	private String note;
	private String profilePic;
	private List<String> department;



}
