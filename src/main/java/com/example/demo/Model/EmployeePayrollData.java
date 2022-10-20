package com.example.demo.Model;

import java.util.Date;
import java.util.List;

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
    private String gender;
    private Date startDate;
    private String note;
    private String profilePic;
    private List<String> department;

    public EmployeePayrollData(int empId, EmployeePayrollDto EmployeePayrollDto) {
        this.empId = empId;
        this.empName = EmployeePayrollDto.empName;
        this.salary = EmployeePayrollDto.salary;
        this.gender = EmployeePayrollDto.getGender();
        this.startDate = EmployeePayrollDto.getStartDate();
        this.note = EmployeePayrollDto.getNote();
        this.profilePic = EmployeePayrollDto.getProfilePic();
        this.department = EmployeePayrollDto.getDepartment();
    }
    public EmployeePayrollData() {

    }



}
