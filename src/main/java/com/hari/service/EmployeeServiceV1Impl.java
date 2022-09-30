package com.hari.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
