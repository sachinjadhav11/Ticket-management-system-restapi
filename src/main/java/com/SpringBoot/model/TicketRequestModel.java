package com.SpringBoot.model;

import javax.persistence.Column;

public class TicketRequestModel
{
       private int ticketId;
	   private String title;
	   private String ticket_description;
	   private String status;
	   private int asignId;
	   private int reportId;
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
	public int getAsignId() {
		return asignId;
	}
	public void setAsignId(int asignId) {
		this.asignId = asignId;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	   
	   
	   
	
	
	  
	
}
