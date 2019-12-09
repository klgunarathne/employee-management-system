package com.example.server.employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	ModelMapper modelMapper = new ModelMapper();


	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	@ResponseBody
	public List<EmployeeDTO> GetEmployees() {
		List<Employee> employee = employeeRepository.findAll();
		return employee.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> GetEmployee(@PathVariable String id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		if(!employeeRepository.findById(id).isPresent()) {
			return new ResponseEntity("Employee not found", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(employee);
	}
	
	@PostMapping
	public Employee AddEmployee(@Valid @RequestBody Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteEmployee(@PathVariable String id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		if(!employee.isPresent()) {
			return new ResponseEntity("Employee not found", HttpStatus.NOT_FOUND);
		}
		employeeRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> EditEmployee(@PathVariable String id, @Valid @RequestBody Employee employee) {
		employee.setE_no(id);

		employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
	}

	private EmployeeDTO convertToDto(Employee employee) {
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		return employeeDTO;
	}

}
