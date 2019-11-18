package com.example.server.department;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public DepartmentController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping()
	public List<Department> GetDepartments() {
		return departmentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Department>> GetDepartment(@PathVariable String id) {
		return ResponseEntity.ok(departmentRepository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Department> AddDepartment(@RequestBody @Valid Department department) {
		departmentRepository.save(department);
		return ResponseEntity.ok(department);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteDepartment(@RequestParam String id) {
		departmentRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}

}
