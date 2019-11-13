package com.example.server.department;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.server.AllocateEmp.Allocate;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long d_id;
	private String name;
	
	@OneToMany
	private List<Allocate> allocates;
	
	
	public List<Allocate> getAllocates() {
		return allocates;
	}
	public void setAllocates(List<Allocate> allocates) {
		this.allocates = allocates;
	}
	public long getD_id() {
		return d_id;
	}
	public void setD_id(long d_id) {
		this.d_id = d_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department() {
		super();
	}
	public Department(long d_id, String name, List<Allocate> allocates) {
		super();
		this.d_id = d_id;
		this.name = name;
		this.allocates = allocates;
	}
	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", name=" + name + ", allocates=" + allocates + "]";
	}	
	
}
