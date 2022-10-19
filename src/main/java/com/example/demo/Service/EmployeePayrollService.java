package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.EmployeePayrollDto;
import com.example.demo.Exception.EmployeePayrollException;
import com.example.demo.Model.EmployeePayrollData;
import com.example.demo.Repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
	private List<EmployeePayrollData> empList = new ArrayList<>();
	@Autowired
	private EmployeePayrollRepository empRepo;


	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {

		return empList;
	}
	/**
	 * To Get Particular Employee Data
	 * Defining  a Custom Exception for Employee Not Found and through when Employee Id is passed as parameter.
	 * Handle such Exceptions in @ExceptionHandler method for EmployeeNotException class.
	 */
	@Override
	public EmployeePayrollData getEmployeePayrollDataByID(int empId) {

		 return empList.stream()
	                .filter(empData -> empData.getEmpId() == empId)
	                .findFirst()
	                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));

	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empList.size() + 1, employeePayrollDto);
		empList.add(empData);

		return empRepo.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData empData = this.getEmployeePayrollDataByID(empId);
        empData.setEmpName(empPayrollDto.empName);
        empData.setSalary(empPayrollDto.salary);
        empList.set(empId - 1, empData);
        return empData;
    }


	@Override
	public void deleteEmployeePayrollData(int empId) {

		empList.remove(empId-1);

	}
}
