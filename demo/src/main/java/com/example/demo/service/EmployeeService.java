package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepositroy;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepositroy employeeRepositroy;
	public Employee addUser(Employee employee) {
		return employeeRepositroy.save(employee);
	}

	public List<Employee> getUsers() {
		List<Employee> users = employeeRepositroy.findAll();
		System.out.println("Getting data from DB : " + users);
		return users;
	}
}
