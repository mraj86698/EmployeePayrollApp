package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.Service.IEmployeePayrollService;

@RestController
@RequestMapping("/EmployeePayroll")
public class EmployeePayrollController {

	@Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData()
    {
        List<EmployeePayrollData> empData = null;
        empData = employeePayrollService.getEmployeePayrollData();
        ResponseDto respDTO = new ResponseDto("Get Call Success", empData);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.getEmployeePayrollDataByID(empId);
        ResponseDto respDTO = new ResponseDto("Get Call Success", employeePayrollData);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeePayrollDto empPayrollDto)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.createEmployeePayrollData(empPayrollDto);
        ResponseDto respDTO = new ResponseDto("Created Employee Payroll Data Successfuly ", employeePayrollData);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }


    @PutMapping(path = "/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @RequestBody EmployeePayrollDto empPayrollDto)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.updateEmployeePayrollData(empPayrollDto);
        ResponseDto respDTO = new ResponseDto("Updated Employee payroll Data for: ", employeePayrollData);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDto respDTO = new ResponseDto("Deleted Employee Data ", empId);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }
}
