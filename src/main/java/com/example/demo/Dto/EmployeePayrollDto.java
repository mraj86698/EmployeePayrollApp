package com.example.demo.Dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * Using @Data is equivalent to
 * using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
 * Generates getters for all fields, a useful toString method, and hashCode and
 * equals implementations that check all non-transient fields.
 */
@Data
public  class EmployeePayrollDto {

	/**
	 * Validation for Employee Name
	 * @NotEmpty annotation is added to name property -Note that the message is thrown when the "Employee name is invalid"
	 */
	@NotEmpty(message = "Employee name cannot be empty")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
	public String empName;
	/**
	 * Validation for Employee Salary
	 * @Min annotation for Salary and corresponding error message
	 */
	@Min(value = 500, message = "Salary should be more than 500")
	@Max(value = 900000, message = "Salary should not exceeds 900000")
	public long salary;
	/**
	 * Validation for Gender
	 * Gender pattern is taken eithers as male or female
	 */
	@Pattern(regexp = "Male|Female|Others", message = "Gender Needs to be Male,Female or Others")
	private String gender;
	/**
	 * Validation for JoinDate
	 * Date is converted to LocalDate using @JsonFormat annotation with pattern.
	 * Pattern fails the Exception is handled in the Exception Handler`
	 * Date is also required and Not Null
	 */
	@JsonFormat(pattern = "dd MM yyyy")
	@NotNull(message = "startDate should Not be Empty")
	@PastOrPresent(message = "startDate should be past or today date")
	private LocalDate startDate;
	/**
	 * Validation for Note
	 * Note is set as required field by using @NotBlank annotation
	 */

	@NotBlank(message = "Note cannot be empty")
	private String note;
	/**
	 * Validation for ProfilePic
	 * Profile Pic is set as required field by using @NotBlank annotation
	 */
	@NotBlank(message = "Profile Pic should not be Empty")
	private String profilePic;
	/**
	 * Validation for Department
	 * Department is set to Not Null Validation and the array is converted to List automatically
	 */
	@NotEmpty(message = "department should not be Empty")
	private List<String> department;



}
