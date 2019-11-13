package com.example.server.department;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<Optional<Department>> GetDepartment(@RequestParam long id) {
		return ResponseEntity.ok(departmentRepository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Department> AddDepartment(@RequestBody @Valid Department department) {
		departmentRepository.save(department);
		return ResponseEntity.ok(department);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> DeleteDepartment(@RequestParam long id) {
		departmentRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}

}
