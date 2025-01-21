package com.emp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dto.EmployeeRequest;
import com.emp.dto.EmployeeResponse;
import com.emp.producer.EmployeeInterface;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/emp")
public class FeignClientController {
	@Autowired
	EmployeeInterface employeeService;

	@PostMapping("/addEmp")
	public EmployeeResponse addEmp(@Valid @RequestBody EmployeeRequest employeeRequest) {
		return employeeService.addEmp(employeeRequest);
	}

	@PutMapping("/updateEmp/{id}")
	public EmployeeResponse updateEmp(@PathVariable int id, @Valid @RequestBody EmployeeRequest updateEmployeeRequest) {
		return employeeService.updateEmp(id, updateEmployeeRequest);
	}

	@DeleteMapping("/delEmp/{id}")
	public void deleteEmp(@PathVariable int id) {
		employeeService.deleteEmp(id);
	}

	@GetMapping("/getEmpList")
	public List<EmployeeResponse> getEmpList() {
		return employeeService.getEmpList();
	}

	@GetMapping("/getEmpById/{id}")
	public EmployeeResponse getEmpById(@PathVariable int id) {
		return employeeService.getEmpById(id);
	}

	@GetMapping("/getEmpListByEmail/{email}")
	public List<EmployeeResponse> fetchEmpByEmail(@PathVariable String email) {
		return employeeService.fetchEmpByEmail(email);
	}

	@GetMapping("/getEmpListByDOJ")
	public List<EmployeeResponse> fetchEmpByDOJ(@RequestParam("doj") String doj) {
		return employeeService.fetchEmpByDOJ(doj);
	}

	@GetMapping("/IsEmployee/{isEmployee}")
	public List<EmployeeResponse> fetchByIsEmployee(@PathVariable boolean isEmployee) {
		return employeeService.fetchByIsEmployee(isEmployee);
	}

	@GetMapping("/getEmpListBySortByField/{field}")
	public List<EmployeeResponse> getEmpListBySortField(@PathVariable String field) {
		return employeeService.getEmpListBySortField(field);
	}

	@GetMapping("/getEmpListByPage/{pageNo}/{PageSize}")
	public Page<EmployeeResponse> getEmpListByPageWise(@PathVariable int pageNo, @PathVariable int PageSize) {
		return employeeService.getEmpListByPageWise(pageNo, PageSize);
	}

	@GetMapping("/getEmpListByPageAndSortbyField/{pageNo}/{PageSize}/{field}")
	public Page<EmployeeResponse> getEmpListByPageWiseBySortField(@PathVariable int pageNo, @PathVariable int PageSize,
			@PathVariable String field) {
		return employeeService.getEmpListByPageWiseBySortField(pageNo, PageSize, field);
	}
}
