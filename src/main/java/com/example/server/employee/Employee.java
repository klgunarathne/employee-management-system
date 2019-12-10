package com.example.server.employee;

import java.util.List;

import javax.persistence.*;

import com.example.server.AllocateEmp.Allocates;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	private String e_no;
	private String name;
	private String address;
	private String status;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Allocates> allocates;
}
