package com.example.server.department;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.server.AllocateEmp.Allocate;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {
	
	@Id
	private String d_no;
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Allocate> allocates;
}
