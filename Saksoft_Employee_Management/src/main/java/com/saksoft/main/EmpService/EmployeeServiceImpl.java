package com.saksoft.main.EmpService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saksoft.main.dao.EmpRepository;
import com.saksoft.main.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	EmpRepository emprepository;
	
	@Override
	public Employee saveEmployee(Employee employee) 
	{
		return emprepository.save(employee);
	}

	@Override
	public List<Employee> getEmployee() {
		return (List<Employee>) emprepository.findAll();
	}

	@Override
	public Employee getSingleEmployee(long id) {
		return emprepository.findById(id).get();
		
	}
	
	@Override
	public void deleteData(long id) {
		emprepository.deleteById(id);
	}

	@Override
	public void updateData(Employee employee) {
		emprepository.save(employee);		
	}

}
