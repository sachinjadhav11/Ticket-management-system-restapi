package com.SpringBoot.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	Employee findByEmployeeId(int empId);

	// Optional<Employee> findByEmail_id(String email_id);
	

}
