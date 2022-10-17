package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.EmployeePayrollDto;

@RestController
@RequestMapping("/home")
public class EmployeePayrollController {
	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<String> getEmployeePayrollData() {

		return new ResponseEntity<String>("Get Call Success For", HttpStatus.OK);

	}
	/**
	 * Testing for Get Mapping using client Url
	 * @param empId
	 * @return
	 */
	@GetMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId) {

		return new ResponseEntity<String>("Get Call Success For ID" + empId, HttpStatus.OK);

	}
	/**
	 * Testing for PostMapping using client Url
	 * @param employeePayrollDto
	 * @return
	 */

	@PostMapping("/create")
	public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto) {

		return new ResponseEntity<String>("Created Employee Payroll Data for" + employeePayrollDto, HttpStatus.OK);
	}
	/**
	 * Testing for Put Mapping Using Client Url
	 * @param empId
	 * @param empPayrollDto
	 * @return
	 */

	@PutMapping("/update/{empId}")
	public ResponseEntity<String> updateEmployeePayroll(@PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDto empPayrollDto) {

		return new ResponseEntity<String>("Updated Employee PayrollData for:" + empPayrollDto, HttpStatus.OK);
	}

	/**
	 * Testing for Delete Mapping Using Client Url
	 * @param empId
	 * @return
	 */
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {

		return new ResponseEntity<String>("Delete Call Success for id:" + empId, HttpStatus.OK);

	}

}
