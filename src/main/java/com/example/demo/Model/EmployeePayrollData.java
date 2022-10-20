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
import lombok.NoArgsConstructor;

/**
 * Using @Data is equivalent to using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
 * Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields.
 * @author mraj
 *
 */

@Data
@NoArgsConstructor
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
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;

    public EmployeePayrollData(EmployeePayrollDto empPayrollDto) {
    	this.updateEmployeePayrollData(empPayrollDto);

    }

	public void updateEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
			this.empId = empId;
	        this.empName = employeePayrollDto.getEmpName();
	        this.salary = employeePayrollDto.getSalary();
	        this.gender = employeePayrollDto.getGender();
	        this.startDate = employeePayrollDto.getStartDate();
	        this.note = employeePayrollDto.getNote();
	        this.profilePic = employeePayrollDto.getProfilePic();
	        this.department = employeePayrollDto.getDepartment();

	}



}
