package com.SpringBoot;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import com.SpringBoot.Repository.EmployeeRepository;

@SpringBootApplication                         // implements CommandLineRunner
public class TicketManagementRestApiApplication  
{
//	@Autowired
//	private PasswordEncoder passwordEncoder;

	public static void main(String[] args)
	{
		SpringApplication.run(TicketManagementRestApiApplication.class, args);
		
		System.out.println("Hello...");
	}

//	@Override
//	public void run(String... args) throws Exception
//	{
//		System.out.println(this.passwordEncoder.encode("rushi98"));
//		
//	}
	
//	@Autowired
//	private EmployeeRepository employeeRepository;
//
//	@Override
//	public void run(String... args) throws Exception 
//	{
//		
//		
//	}
}