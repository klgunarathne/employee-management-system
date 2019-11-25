package com.example.server.department;

import javax.persistence.*;

import com.example.server.AllocateEmp.Allocate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {
	@Id
	private String d_no;
	private String name;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Allocate> allocates;
}
