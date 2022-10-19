package com.example.demo.Model;

import com.example.demo.Dto.EmployeePayrollDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Using @Data is equivalent to using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
 * Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields.
 * @author mraj
 *
 */

@Data
@Getter
@Setter
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

}
