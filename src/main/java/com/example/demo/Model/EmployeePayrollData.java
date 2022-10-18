package com.example.demo.Model;

import com.example.demo.Dto.EmployeePayrollDto;

import lombok.Data;

/**
 * Using @Data is equivalent to using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
 * Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields.
 * @author mraj
 *
 */

@Data
public class EmployeePayrollData {

    private int empId;
    private String empName;
    private long salary;

    public EmployeePayrollData(int empId, EmployeePayrollDto employeePayrollDto) {
        this.empId = empId;
        this.empName = employeePayrollDto.empName;
        this.salary = employeePayrollDto.salary;
    }

    public EmployeePayrollData(String empName, long salary) {
    }
    /**
     * Employee Payroll Data Getter And Setter Method
     * @return
     */
    public long getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
