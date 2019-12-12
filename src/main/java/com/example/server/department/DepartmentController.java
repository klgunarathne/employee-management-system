package com.example.server.department;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.server.loggin.LOGS;
import com.example.server.loggin.LoggingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private LoggingService loggingService;

	ModelMapper modelMapper = new ModelMapper();
	
	public DepartmentController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping()
	public List<DepartmentDTO> GetDepartments() {
		List<Department> departments = departmentRepository.findAll();
		LOGS logs = new LOGS();
		logs.setLOG_LEVEL("info");
		logs.setMESSAGE("Get All Departments");
		logs.setLOGGER("department");
		loggingService.Save(logs);
		return (departments.stream().map(this::convertToDto).collect(Collectors.toList()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Department>> GetDepartment(@PathVariable String id) {
		LOGS logs = new LOGS();
		logs.setLOG_LEVEL("info");
		logs.setMESSAGE("Get Departments " + id);
		logs.setLOGGER("department");
		loggingService.Save(logs);
		return ResponseEntity.ok(departmentRepository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Department> AddDepartment(@RequestBody @Valid Department department) {
		departmentRepository.save(department);
		LOGS logs = new LOGS();
		logs.setLOG_LEVEL("info");
		logs.setMESSAGE("Add new Departments " + department.toString());
		logs.setLOGGER("department");
		loggingService.Save(logs);
		return ResponseEntity.ok(department);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteDepartment(@PathVariable String id) {
		departmentRepository.deleteById(id);
		LOGS logs = new LOGS();
		logs.setLOG_LEVEL("info");
		logs.setMESSAGE("Delete Departments " + id);
		logs.setLOGGER("department");
		loggingService.Save(logs);
		return ResponseEntity.ok(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Department> EditDepartment(@PathVariable String id, @RequestBody @Valid Department department) {
		department.setD_no(id);
		departmentRepository.save(department);
		LOGS logs = new LOGS();
		logs.setLOG_LEVEL("info");
		logs.setMESSAGE("Edit Departments");
		logs.setLOGGER("department");
		loggingService.Save(logs);
		return ResponseEntity.ok(department);
	}

	private DepartmentDTO convertToDto(Department department) {
		DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
		return departmentDTO;
	}

}
