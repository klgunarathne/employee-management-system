package com.example.server.employee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.server.AllocateEmp.Allocate;
import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long e_id;
	private String name;
	
	@OneToMany(mappedBy = "employee")
	private List<Allocate> Allocates;
	
	
	public List<Allocate> getAllocates() {
		return Allocates;
	}
	public void setAllocates(List<Allocate> allocates) {
		Allocates = allocates;
	}
	public long getE_id() {
		return e_id;
	}
	public void setE_id(long e_id) {
		this.e_id = e_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee() {
		super();
	}
	public Employee(long e_id, String name, List<Allocate> allocates) {
		super();
		this.e_id = e_id;
		this.name = name;
		Allocates = allocates;
	}
	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", name=" + name + ", Allocates=" + Allocates + "]";
	}
	
	
}
