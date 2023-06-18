package com.SpringBoot.Service;

import java.util.List;

import com.SpringBoot.Entity.Employee;
import com.SpringBoot.Entity.Ticket;


public interface EmployeeService
{
	public List<Employee> getallEmployees();
	   
	   public void addEmployee(Employee employee);
	   
	   public void deleteEmployee(Integer  employee_id);
	   
	   public Employee getEmployeeById(Integer employee_id);
 
	   public void updateEmployee(Employee employee);
}
