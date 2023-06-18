package com.SpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Entity.Employee;
import com.SpringBoot.Entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>
{
	Ticket findByTicketId(int empId);
	
	List<Ticket> findByAsigneeEmployeeId(Integer employeeId);
	
 
	

}

