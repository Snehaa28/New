package com.example.demo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepositroy;
import com.example.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMockitoTestCases {

	@Autowired
	private EmployeeService service;

	@MockBean
	private EmployeeRepositroy repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Employee(1, "Raju", 31, "IND"), new Employee(2, "Kiran", 35, "UK")).collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}


	@Test
	public void saveUserTest() {
		Employee user = new Employee(999, "Pranya", 33, "Pune");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}


}
