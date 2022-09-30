package com.hari.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hari.Exception.EmployeeNotFoundException;
import com.hari.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	List<Employee> list = new ArrayList<Employee>();

	@Override
	public Employee Save(Employee e) {

		if (e.getEmployeeId() == null || e.getEmailId().isEmpty())
			e.setEmployeeId(UUID.randomUUID().toString());
		list.add(e);
		return e;
	}

	@Override
	public List<Employee> allEmployee() {
		return list;
	}

	@Override
	public Employee getEmployeeById(String id) {
		return list.stream().filter(x -> x.getEmployeeId().equals(id)).findFirst()
				.orElseThrow(() -> new EmployeeNotFoundException ("Employee Not found" + id));

	}

	@Override
	public String deleteEmployeeById(String id) {
	   Employee employee=list.stream().filter(x->x.getEmployeeId().equalsIgnoreCase(id)).findFirst().
			   orElseThrow(()->new EmployeeNotFoundException("Employee Not Found:"+id));
	   list.remove(employee);
		return "Employee deleted from list:"+id;
	}

}
