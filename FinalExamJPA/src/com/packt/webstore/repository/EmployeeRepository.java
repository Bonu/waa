package com.packt.webstore.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	@Query(value = "select employee from Employee employee where employee.id=?1")
	public Employee locateOneEmployeeByHisNumber(int employeeId);
}
