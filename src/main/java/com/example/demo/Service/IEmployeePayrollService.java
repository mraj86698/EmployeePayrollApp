package com.example.demo.Service;

import java.util.List;

import com.example.demo.Dto.EmployeePayrollDto;
import com.example.demo.Model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataByID(int empId);

	List<EmployeePayrollData> getEmployeePayrollDataByDepartment(String department);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto empPayrollDto);

	void deleteEmployeePayrollData(int empId);

	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto employeePayrollDto);



}
