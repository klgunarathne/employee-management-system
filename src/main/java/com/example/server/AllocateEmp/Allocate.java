package com.example.server.AllocateEmp;

import com.example.server.department.Department;
import com.example.server.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Data
public class Allocate {
	
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
	
	@ManyToOne
	@JoinColumn
	private Department department;
}
