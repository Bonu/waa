package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Employee;

public interface EmployeeService {

	public Employee locateOneEmployeeByHisNumber(int id);

	public List<Employee> getAllEmployees();

	public Employee addEmployee(Employee employee);

}
