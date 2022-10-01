package com.hari.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hari.entity.EmployeeEntity;
import com.hari.model.Employee;
import com.hari.repository.EmployeeRepository;

@Service
public class EmployeeServiceV1Impl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee Save(Employee e) {

		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(e, entity);
		repo.save(entity);
		return e;
	}

	@Override
	public List<Employee> allEmployee() {
		List<EmployeeEntity> allEmployee = repo.findAll();
		List<Employee> employees = allEmployee.stream().map(employeeEntity -> {
			Employee e = new Employee();
			BeanUtils.copyProperties(employeeEntity, e);
			return e;
		}).collect(Collectors.toList());
		return employees;
	}

	@Override
	public Employee getEmployeeById(String id) {
		EmployeeEntity employeeEntity=repo.findById(id).get();
		Employee e = new Employee();
		BeanUtils.copyProperties(employeeEntity, e);
		return e;
	}

	@Override
	public String deleteEmployeeById(String id) {
		repo.deleteById(id);
		return "Employee deleted successfully";
	}

}
