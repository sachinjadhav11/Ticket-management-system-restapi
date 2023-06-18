package com.SpringBoot.Entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Comment")
public class Comment 
{
	
  
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TicketComment_id;
  
  @Column(name="Ticket_Comment")
  private String TicketComment;
  
  @Column()
  private long ticketCommentDate;
  

  @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Employee.class)
  @JoinColumn(name = " employeeId", referencedColumnName = "employeeId", nullable = false)
  private Employee employee;
  
  @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Ticket.class)
  @JoinColumn(name = " ticketId", referencedColumnName = " ticketId", nullable = false)
  private Ticket ticket;



public long getTicketComment_id() {
	return TicketComment_id;
}

public void setTicketComment_id(int ticketComment_id) {
	TicketComment_id = ticketComment_id;
}

public String getTicketComment() {
	return TicketComment;
}

public void setTicketComment(String ticketComment) {
	TicketComment = ticketComment;
}






public long getTicketCommentDate() {
	return ticketCommentDate;
}

public void setTicketCommentDate(long ticketCommentDate) {
	this.ticketCommentDate = ticketCommentDate;
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



public Comment() {
	super();
	// TODO Auto-generated constructor stub
}
  
  

}
