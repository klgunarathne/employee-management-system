package com.example.server.AllocateEmp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/allocate")
public class AllocateController {
	
	@Autowired
	private AllocateRepository _repository;
	
	public AllocateController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	public ResponseEntity<List<Allocates>> GetAll() {
		return ResponseEntity.ok(_repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Allocates>> GetAllocate(@PathVariable Long id) {
		if(!_repository.findById(id).isPresent()) {
			return  ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(_repository.findById(id));
	}

	@PostMapping
	public ResponseEntity<Allocates> AddAllocate(@RequestBody @Valid Allocates allocate) {

		Allocates a = new Allocates();
		a.setPercentage(allocate.getPercentage());
		a.setFrom_date(allocate.getFrom_date());
		a.setTo_date(allocate.getTo_date());
		a.setDepartment(allocate.getDepartment());
		a.setEmployee(allocate.getEmployee());
		a.setD_no(allocate.getDepartment().getD_no());
		a.setE_no(allocate.getEmployee().getE_no());

		_repository.save(a);
		return  ResponseEntity.ok(a);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteAllocate(@PathVariable Long id) {
		if(!_repository.findById(id).isPresent()) {
			return  ResponseEntity.notFound().build();
		}
		_repository.deleteById(id);
		return  ResponseEntity.ok(id.toString());
	}

	@GetMapping("/employee/{ENo}")
	public ResponseEntity<List<Allocates>> GetAllocatesFromENo(@PathVariable String ENo) {
		LocalDate todayDate = LocalDate.now();
		List<Allocates> allocates = _repository.GetAllocationsByEmployeeNo(ENo, todayDate);
		if(allocates.isEmpty()) {
			return (new ResponseEntity("Employee not allocated", HttpStatus.NOT_FOUND));
		}

		AllocateDashboard data = new AllocateDashboard();

		if(!allocates.isEmpty()) {
			allocates.forEach(a -> {
				data.setDepartment(a.getDepartment());
				data.setPercentage((float) a.getPercentage());
			});
		}

		return ResponseEntity.ok(allocates);
	}
}
