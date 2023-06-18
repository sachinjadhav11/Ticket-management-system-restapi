package com.SpringBoot.model;

public class UpdateStatusRequestModel
{
  private int ticketId;
  
  private String Status;
  
public int getTicketId()
{
	return ticketId;
}
public void setTicketId(int ticketId) 
{
	this.ticketId = ticketId;
}
public String getStatus()
{
	return Status;
}
public void setStatus(String status) 
{
	Status = status;
}
  
  
}
