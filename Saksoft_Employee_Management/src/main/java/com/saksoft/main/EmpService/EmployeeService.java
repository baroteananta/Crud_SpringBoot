package com.saksoft.main.EmpService;

import java.util.List;
import java.util.Optional;

import com.saksoft.main.model.Employee;


public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getEmployee();

	void deleteData(long id);

	Employee getSingleEmployee(long id);

	void updateData(Employee employee);



}
