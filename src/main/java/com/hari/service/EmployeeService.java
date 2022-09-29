package com.hari.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.hari.model.Employee;

public interface EmployeeService {

	public Employee Save(Employee e);
	public List<Employee> allEmployee();
	public Employee getEmployeeById(String id);
	public String deleteEmployeeById(String id);

}
