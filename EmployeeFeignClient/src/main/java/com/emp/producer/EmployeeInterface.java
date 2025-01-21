package com.emp.producer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.dto.EmployeeRequest;
import com.emp.dto.EmployeeResponse;

import jakarta.validation.Valid;
@FeignClient("EMPLOYEESERVICE-EX3")
public interface EmployeeInterface {
	@PostMapping("/addEmp")
	public EmployeeResponse addEmp(@Valid @RequestBody EmployeeRequest employeeRequest);

	@PutMapping("/updateEmp/{id}")
	public EmployeeResponse updateEmp(@PathVariable int id, @Valid @RequestBody EmployeeRequest updateEmployeeRequest);

	@DeleteMapping("/delEmp/{id}")
	public void deleteEmp(@PathVariable int id);

	@GetMapping("/getEmpList")
	public List<EmployeeResponse> getEmpList();

	@GetMapping("/getEmpById/{id}")
	public EmployeeResponse getEmpById(@PathVariable int id);

	@GetMapping("/getEmpListByEmail/{email}")
	public List<EmployeeResponse> fetchEmpByEmail(@PathVariable String email);

	@GetMapping("/getEmpListByDOJ")
	public List<EmployeeResponse> fetchEmpByDOJ(@RequestParam("doj") String doj);

	@GetMapping("/IsEmployee/{isEmployee}")
	public List<EmployeeResponse> fetchByIsEmployee(@PathVariable boolean isEmployee);

	@GetMapping("/getEmpListBySortByField/{field}")
	public List<EmployeeResponse> getEmpListBySortField(@PathVariable String field);

	
	@GetMapping("/getEmpListByPage/{pageNo}/{PageSize}")
	public Page<EmployeeResponse> getEmpListByPageWise(@PathVariable int pageNo, @PathVariable int PageSize);

	
	@GetMapping("/getEmpListByPageAndSortbyField/{pageNo}/{PageSize}/{field}")
	public Page<EmployeeResponse> getEmpListByPageWiseBySortField(@PathVariable int pageNo, @PathVariable int PageSize,
			@PathVariable String field);
}
