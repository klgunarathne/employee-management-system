package com.example.server.department;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;

	ModelMapper modelMapper = new ModelMapper();
	
	public DepartmentController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping()
	public List<DepartmentDTO> GetDepartments() {
		List<Department> departments = departmentRepository.findAll();
		return (departments.stream().map(this::convertToDto).collect(Collectors.toList()));
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
	public ResponseEntity<String> DeleteDepartment(@PathVariable String id) {
		departmentRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Department> EditDepartment(@PathVariable String id, @RequestBody @Valid Department department) {
		department.setD_no(id);
		departmentRepository.save(department);
		return ResponseEntity.ok(department);
	}

	private DepartmentDTO convertToDto(Department department) {
		DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
		return departmentDTO;
	}

}
