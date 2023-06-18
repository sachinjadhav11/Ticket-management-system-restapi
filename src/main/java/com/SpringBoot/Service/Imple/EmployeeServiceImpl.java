package com.SpringBoot.Service.Imple;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Entity.Employee;
import com.SpringBoot.Repository.EmployeeRepository;
import com.SpringBoot.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getallEmployees() 
	{
		List<Employee> employees= new ArrayList<>();
		employeeRepository.findAll().forEach(employee->employees.add(employee));
		return employees;
		
	}

	@Override
	public void addEmployee(Employee employee)
	{
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Integer employee_id)
	{
		employeeRepository.deleteById(employee_id);
	}

	@Override
	public void updateEmployee(Employee employee)
	{
		employeeRepository.save(employee);
	}
	
	public Employee getEmployeeById(Integer employee_id)
	{
		return employeeRepository.findById(employee_id)
				.orElseThrow(()-> new IllegalStateException("Employee not found with id "+employee_id));
				
		
		 
	}


}
