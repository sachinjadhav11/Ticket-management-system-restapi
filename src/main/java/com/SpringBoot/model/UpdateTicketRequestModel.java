package com.SpringBoot.model;

public class UpdateTicketRequestModel 
{
  
	private String title;
	
	private String ticket_description;
	
	private int asignId;

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

	public int getAsignId() {
		return asignId;
	}

	public void setAsignId(int asignId) {
		this.asignId = asignId;
	}

	
}
