package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.packt.webstore.domain.Employee;
import com.packt.webstore.repository.EmployeeRepository;
import com.packt.webstore.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee locateOneEmployeeByHisNumber(int id) {
		return employeeRepository.locateOneEmployeeByHisNumber(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		Iterable<Employee> itrEmployees = employeeRepository.findAll();
		return Lists.newArrayList(itrEmployees);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
