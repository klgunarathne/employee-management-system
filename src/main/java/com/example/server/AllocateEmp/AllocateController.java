package com.example.server.AllocateEmp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api/allocate")
public class AllocateController {
	
	@Autowired
	private AllocateRepository _repository;
	
	public AllocateController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	public List<Allocate> GetAll() {
		return _repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Allocate> GetAllocate(@PathVariable Long id) {
		return _repository.findById(id);
	}
}
