package com.example.server.employee;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping()
	public Iterable<Employee> GetEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity GetEmployee(@PathVariable Long id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee == null) {
			return new ResponseEntity("Employee not found", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(employeeRepository.findById(id));
	}
	
	@PostMapping
	public Employee AddEmployee(@Valid @RequestBody Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> DeleteEmployee(@PathVariable Long id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		if(!employee.isPresent()) {
			return new ResponseEntity("Employee not found", HttpStatus.NOT_FOUND);
		}
		employeeRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}

}
