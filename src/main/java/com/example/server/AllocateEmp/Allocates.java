package com.example.server.AllocateEmp;

import com.example.server.department.Department;
import com.example.server.employee.Employee;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Data
public class Allocates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int percentage;
	private int duration;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate from_date;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate to_date;
	
	@ManyToOne
	@JoinColumn
	private Employee employee;
	private String d_no;
	
	@ManyToOne
	@JoinColumn
	private Department department;
	private String e_no;
}
