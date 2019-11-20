package com.example.server.employee;

import java.util.List;

import javax.persistence.*;

import com.example.server.AllocateEmp.Allocate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
@Access(value= AccessType.FIELD)
public class Employee {

	@Id
	private String e_no;
	private String name;
	private String address;
	private String status;

	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Allocate> Allocates;
}
