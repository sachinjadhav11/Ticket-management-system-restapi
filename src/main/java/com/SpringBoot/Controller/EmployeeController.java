package com.SpringBoot.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Entity.Employee;
import com.SpringBoot.Entity.Ticket;
import com.SpringBoot.Service.EmployeeService;



@RestController
public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getallEmployees();
		
	}
  
	 @GetMapping("/employee/{employee_id}")
		public Employee getemployee(@PathVariable("employee_id") Integer employee_id )
		{
			return employeeService.getEmployeeById(employee_id);
		}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		employeeService.addEmployee(employee);
		return employee;
	}
	
	@DeleteMapping("/employee/{employee_id}")
	public void deleteEmployee(@PathVariable("employee_id") Integer employee_id)
	{
		employeeService.deleteEmployee(employee_id);
	}
	
	
	@PutMapping("/employee")
	   public void updateEmployee(@RequestBody Employee employee)
	   {
		 employeeService.updateEmployee(employee);
	   }
	
	
}
