package com.SpringBoot.Entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name= "ticket" )
public class Ticket
{
  
   
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
   
   @Column(name="ticket_name", nullable=false)
   private String title;
    
   @Column(name="ticket_description")
   private String ticket_description;
   
   @Column
   private String status;
   
   @OneToOne(cascade = CascadeType.MERGE, targetEntity = Employee.class)
   @JoinColumn(name = "reporter_emp_id", referencedColumnName = "employeeId", nullable=false)
   private Employee reporter;
   
   @OneToOne(cascade = CascadeType.MERGE, targetEntity = Employee.class)
   @JoinColumn(name = "asignee_emp_id", referencedColumnName = "employeeId", nullable=false) 
   private Employee asignee;





public int getTicketId() {
	return ticketId;
}

public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getTicket_description() {
	return ticket_description;
}

public void setTicket_description(String ticket_description) {
	this.ticket_description = ticket_description;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Employee getReporter() {
	return reporter;
}

public void setReporter(Employee reporter) {
	reporter = reporter;
}

public Employee getAsignee() {
	return asignee;
}

public void setAsignee(Employee asignee) {
	asignee = asignee;
}
 
}
