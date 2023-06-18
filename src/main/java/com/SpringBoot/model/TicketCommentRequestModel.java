package com.SpringBoot.model;

public class TicketCommentRequestModel {
private int employeeId;
private int ticketId;
private String ticketComment;


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
public String getTicketComment() {
	return ticketComment;
}
public void setTicketComment(String ticketComment) {
	this.ticketComment = ticketComment;
}



	
}
