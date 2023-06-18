package com.SpringBoot.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "worklog")
public class Worklog
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int worklogId;
	
	  @OneToOne(cascade = CascadeType.MERGE, targetEntity = Employee.class)
	  @JoinColumn(name = "employeeId", referencedColumnName = "employeeId", nullable = false)
	  private Employee employee;
	  
	  @OneToOne(cascade = CascadeType.MERGE, targetEntity = Ticket.class)
	  @JoinColumn(name="ticketId", referencedColumnName = "ticketId", nullable = false)
	  private Ticket ticket;
	  
	  @JsonFormat(pattern = "YYYY-MM-DD", shape = Shape.STRING)
	  @Column
	  private String date;
	  
	  @Column
	  private String timespend;
	  
	  @Column(name = "description")
	  private String worklogDescription;

	public Worklog() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public int getWorklogId() {
		return worklogId;
	}

	public void setWorklogId(int worklogId) {
		this.worklogId = worklogId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimespend() {
		return timespend;
	}

	public void setTimespend(String timespend) {
		this.timespend = timespend;
	}

	public String getWorklogDescription() {
		return worklogDescription;
	}

	public void setWorklogDescription(String worklogDescription) {
		this.worklogDescription = worklogDescription;
	}
	
	

	
	  
}
