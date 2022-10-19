package com.example.demo.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

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
/**
 * @Entity Annotation tells Hibernate to create a table out of the Employee Payroll Class
 */
@Entity
/**
 * @Table specifies the mapped Table in DB
 */
@Table(name="employee_payroll")
public class EmployeePayrollData {
	/**
	 * @Id specifies the Primary Key and id generation is set to auto
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	/**
	 * @Column specifies the mapped Column Name in the Database. By default is the variable name
	 */
	@Column(name="EmpId")
	private int empId;
	@Column(name="EmpName")

    private String empName;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    /**
     * @ElementCollection and @CollectionTable is required for One to Many relationship
     * @JoinColumn that refers to the primary table.
     */
    @ElementCollection
    @CollectionTable(name="employee_department",joinColumns=@JoinColumn(name="id"))
    @Column(name="department")
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
