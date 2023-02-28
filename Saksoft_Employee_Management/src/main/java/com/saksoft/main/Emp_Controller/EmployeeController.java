package com.saksoft.main.Emp_Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.saksoft.main.EmpService.EmployeeService;
import com.saksoft.main.model.Employee;


@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/getdata")
	public List<Employee> getData()
	{
		return employeeService.getEmployee();
	}
	
	
	@GetMapping("/getdata/{id}")
	public Employee getSingleEmployee(@PathVariable ("id") long id)
	{
		return employeeService.getSingleEmployee(id);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable ("id") long id)
	{
		employeeService.deleteData(id);
		 
		 return "data deleted succussfully"; 
		 
	}
	
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") long id,@RequestBody Employee empl)
	{
		 Employee employee = employeeService.getSingleEmployee(id);
		if(employee.getId()==id)
		{
			employee.setFirstName(empl.getFirstName());
			employee.setLastName(empl.getLastName());
			employee.setEmail(empl.getEmail());
			employee.setAge(empl.getAge());
			System.out.println("Method run....");
			
			employeeService.updateData(employee);
		}
		 
		return new ResponseEntity<Employee>(HttpStatus.OK);
		
	}
	
}
