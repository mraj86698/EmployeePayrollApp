package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.EmployeePayrollDto;
import com.example.demo.Exception.EmployeePayrollException;
import com.example.demo.Model.EmployeePayrollData;
import com.example.demo.Repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService{

	@Autowired
	private EmployeePayrollRepository empRepo;


	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {

		return empRepo.findAll();
	}
	/**
	 * To Get Particular Employee Data
	 * Defining  a Custom Exception for Employee Not Found and through when Employee Id is passed as parameter.
	 * Handle such Exceptions in @ExceptionHandler method for EmployeeNotException class.
	 */
	@Override
	public EmployeePayrollData getEmployeePayrollDataByID(int empId) {

		 return empRepo
	                .findById(empId)
	                .orElseThrow(() -> new EmployeePayrollException("Employee with "+empId+"does not exists"));

	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(employeePayrollDto);
		//log.debug("Emp Data : "+empData.toString());
		return empRepo.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData empData = this.getEmployeePayrollDataByID(empId);
        empData.updateEmployeePayrollData(empPayrollDto);
        return empRepo.save(empData);
    }


	@Override
	public void deleteEmployeePayrollData(int empId) {

		EmployeePayrollData emp = this.getEmployeePayrollDataByID(empId);
		empRepo.delete(emp);

	}
}
