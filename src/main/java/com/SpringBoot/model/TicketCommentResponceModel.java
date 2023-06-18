package com.SpringBoot.model;

public class TicketCommentResponceModel
{
  private int TicketComment_id;
  
  private String TicketComment;
  
  private int employeeId;
  
  private int ticketId;
  
  private String date;

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public int getTicketComment_id() {
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

public int getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}

public int getTicketId() {
	return ticketId;
}

public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}
  
  
}
