package com.hari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.model.Employee;
import com.hari.service.EmployeeService;
//Controller

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

	@Qualifier("employeeServiceImpl")
	@Autowired
	private EmployeeService employeeServiceImpl;

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee e) {
		return employeeServiceImpl.Save(e);
	}
	
	@GetMapping
	public List<Employee>getAllEmployees()
	{
		return employeeServiceImpl.allEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return employeeServiceImpl.getEmployeeById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable String id)
	{
		return employeeServiceImpl.deleteEmployeeById(id);
	}
}
