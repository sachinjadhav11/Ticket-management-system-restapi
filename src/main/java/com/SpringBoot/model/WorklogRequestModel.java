package com.SpringBoot.model;

public class WorklogRequestModel
{
	 private int worklogId;
	 
	 private int employeeId;
	 
	 private int ticketId;
	 
	 private String date;

	 private String timespend;
	 
	 private String worklogDescription;

	public int getWorklogId() {
		return worklogId;
	}

	public void setWorklogId(int worklogId) {
		this.worklogId = worklogId;
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
