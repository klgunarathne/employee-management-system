package com.example.server.department;

import javax.persistence.*;

import com.example.server.AllocateEmp.Allocates;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private List<Allocates> allocates;
}
