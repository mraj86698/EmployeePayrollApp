package com.example.demo.Controller;

import java.util.List;

import javax.validation.Valid;

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
	/**
	 * Request Mapping Using To Get All Employee Details
	 * @return
	 */
    @RequestMapping(value = {"", "/", "/getAll"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData()
    {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDto respDTO = new ResponseDto("Get Call Success", empDataList);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }

    /**
     * Get Mapping Using to Get Particular Employee Id
     * @param empId
     * @return
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.getEmployeePayrollDataByID(empId);
        ResponseDto respDTO = new ResponseDto("Get Call Success", employeePayrollData);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }
    /**
     * Post Mapping Using to Create New Employee Data
     * @param empPayrollDto
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDto empPayrollDto)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.createEmployeePayrollData(empPayrollDto);
        ResponseDto respDTO = new ResponseDto("Created Employee Payroll Data Successfuly ", employeePayrollData);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }

    /**
     * Put Mapping Using to Update Already Created Employee Data
     * @param empId
     * @param empPayrollDTO
     * @return
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("empId") int empId,
    		@Valid @RequestBody EmployeePayrollDto empPayrollDTO) {

        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDto respDTO = new ResponseDto("Updated Employee payroll Data for: ", empData);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }
    /**
     * Delete Mapping Using to Delete Employee Data
     * @param empId
     * @return
     */

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDto respDTO = new ResponseDto("Deleted Employee Data ", empId);
        return new ResponseEntity<ResponseDto> (respDTO, HttpStatus.OK);
    }
}
