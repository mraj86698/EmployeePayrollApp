package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.EmployeePayrollDto;
import com.example.demo.Model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        employeePayrollDataList.add(new EmployeePayrollData(1,new EmployeePayrollDto("Mohan" ,300000)));
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataByID(int empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDto("Mohan",30000));
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDto employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {

    }
}
