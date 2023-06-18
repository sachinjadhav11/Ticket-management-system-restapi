//package com.SpringBoot.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.SpringBoot.Entity.Employee;
//import com.SpringBoot.Exception.ResourceNotFoundException;
//import com.SpringBoot.Repository.EmployeeRepository;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService
//{
//    @Autowired
//	private EmployeeRepository employeeRepository;
//    
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//	{
////		Employee employee= this.employeeRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("Employee", "email_id",username));
////		return  employee;
//		
//		Employee employee= this.employeeRepository.findByEmail_id(username).orElseThrow(()-> new ResourceNotFoundException("Employee", "email_id:"+username, 0));
//		return employee;
//	}
//
//}
