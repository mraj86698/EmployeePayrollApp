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
import com.example.demo.Dto.ResponseDto;
import com.example.demo.Model.EmployeePayrollData;

@RestController
@RequestMapping("/EmployeePayroll")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData()
    {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, new EmployeePayrollDto("Mohan", 30000));
        ResponseDto respDTO = new ResponseDto("Get Call Success", empData);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDto("Mohan", 30000));
        ResponseDto respDTO = new ResponseDto("Get Call Success", employeePayrollData);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeePayrollDto empPayrollDto)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, empPayrollDto);
        ResponseDto respDTO = new ResponseDto("Created Employee Payroll Data Successfuly ", employeePayrollData);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }


    @PutMapping(path = "/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @RequestBody EmployeePayrollDto empPayrollDTO)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId, empPayrollDTO);
        ResponseDto respDTO = new ResponseDto("Updated Employee payroll Data for: ", employeePayrollData);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        ResponseDto respDTO = new ResponseDto("Deleted SuccessFully","Deleted Id"+	 empId);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }
}
