package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired 
	EmployeeService employeeService;
	
	@PostMapping(value = "/save")
	public Employee saveUser(@RequestBody Employee user) {
		return employeeService.addUser(user);
	}

	@GetMapping("/getUsers")
	public List<Employee> findAllUsers() {
		return employeeService.getUsers();
	
	}

}
