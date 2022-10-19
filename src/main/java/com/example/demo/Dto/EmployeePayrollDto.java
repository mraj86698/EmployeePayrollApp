package com.example.demo.Dto;

public class EmployeePayrollDto {

	public String empName;
	public long salary;

	public EmployeePayrollDto(String empName, long salary) {
		this.empName = empName;
		this.salary = salary;
	}
=======

	

=======


	@Override
	public String toString() {
		return "EmployeePayrollData{" + "name='" + empName + '\'' + ", salary=" + salary + '}';
	}


}
