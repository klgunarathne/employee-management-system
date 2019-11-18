package com.example.server.AllocateEmp;

import com.example.server.department.Department;
import com.example.server.employee.Employee;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Allocate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int percentage;
	private int duration;
	private Date from_date;
	private Date to_date;
	
	@ManyToOne()
	@JoinColumn(name = "employee_e_no")
	private Employee employee;
	
	@OneToOne
	@JoinColumn(name = "department_d_no")
	private Department department;
}
